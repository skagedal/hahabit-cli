mod config;

use termion::raw::IntoRawMode;
use termion::event::Key;
use termion::input::TermRead;
use std::io::{Write, stdout, stdin};
use chrono::NaiveDate;
use openapi::apis::configuration::Configuration;
use openapi::apis::{Error, hahabit_api};
use openapi::apis::hahabit_api::{GetHabitsForDateError, TrackHabitError};
use openapi::models::{GetHabitsForDate200Response, HabitForDate};
use crate::config::{Config, ConfigError, read_config};

extern crate termion;

fn main() {
    let today = chrono::Local::now().date_naive();
    print!("{}... ", today);
    stdout().flush().unwrap();

    let config = read_config().unwrap_or_else(|e| {
        match e {
            ConfigError::OpenFile(path, error) => {
                eprintln!("Unable to open config file: {}", path.display());
                eprintln!("Error: {}", error);
                eprintln!("Make sure this file exists, is readable and looks something like this:\n\n\
                           username = 'username'\n\
                           password = 'password'\n\n\
                           (Yes, keeping passwords directly in the file is bad practice. This is alpha software.)");
            }
            ConfigError::InvalidFile(error) => {
                eprintln!("Unable to read config file");
                eprintln!("Error: {}", error);
            }
        }
        std::process::exit(1);
    });

    let api_config = api_configuration(config);
    let habits = get_habits(&api_config, today).unwrap_or_else(|e| {
        eprintln!("Unable to get habit tracking status: {}", e);

        std::process::exit(1);
    }).habits;

    if all_done(&habits) {
        println!("all done!");
        return;
    } else {
        println!("")
    }

    let stdin = stdin();
    let mut stdout = stdout().into_raw_mode().unwrap();

    let mut first = true;
    for habit in &habits {
        if !first {
            write!(stdout, "\r\n").unwrap();
        }
        write!(stdout, "{} {}",
            match habit.tracking_id {
                Some(_) => "✅",
                None => "❌"
            },
               habit.description).unwrap();
        first = false;
    }

    let distance: u16 = (habits.len() - 1).try_into().unwrap();
    write!(stdout, "\r{}", termion::cursor::Up(distance)).unwrap();

    stdout.flush().unwrap();

    let mut current = 0;
    let max = habits.len() - 1;

    for c in stdin.keys() {
        match c.unwrap() {
            Key::Char('q') => break,
            Key::Up => {
                if current > 0 {
                    current -= 1;
                    write!(stdout, "{}", termion::cursor::Up(1)).unwrap()
                }
            }
            Key::Down => {
                if current < max {
                    current += 1;
                    write!(stdout, "{}", termion::cursor::Down(1)).unwrap()
                }
            }
            Key::Char('\n') => {
                write!(stdout, "⏳\r").unwrap();
                stdout.flush().unwrap();
                track_habit(&api_config, habits[current].habit_id, today).unwrap();
                write!(stdout, "✅\r").unwrap();
            }
            _ => {}
        }

        stdout.flush().unwrap();
    }

    write!(stdout, "{}\r\n", termion::cursor::Down((max - current) as u16)).unwrap();
}

fn all_done(habits: &Vec<HabitForDate>) -> bool {
    habits.iter().all(|h| h.tracking_id.is_some())
}


fn get_habits(config: &Configuration, today: NaiveDate) -> Result<GetHabitsForDate200Response, Error<GetHabitsForDateError>> {
    hahabit_api::get_habits_for_date(&config, today.to_string())
}

fn track_habit(config: &Configuration, habit_id: i64, today: NaiveDate) -> Result<(), Error<TrackHabitError>> {
    hahabit_api::track_habit(&config, today.to_string(), habit_id)
        .map(|_| ())
}

fn api_configuration(config: Config) -> Configuration {
    let mut api_config = Configuration::default();
    api_config.basic_auth = Some((config.username, Some(config.password)));
    api_config
}
