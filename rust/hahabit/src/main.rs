use std::fs;
use termion::raw::IntoRawMode;
use termion::event::Key;
use termion::input::TermRead;
use std::io::{Write, stdout, stdin};
use chrono::NaiveDate;
use openapi::apis::configuration::{BasicAuth, Configuration};
use openapi::apis::{Error, hahabit_api};
use openapi::apis::hahabit_api::{GetHabitsForDateError, TrackHabitError};
use openapi::models::{GetHabitsForDate200Response, HabitForDate};
use toml::Table;

extern crate termion;

fn main() {
    let today = chrono::Local::now().date_naive();
    print!("{}... ", today);

    let api_config = configuration();
    let habits = get_habits(&api_config, today)
        .expect("Failed to get habits for date")
        .habits;

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

fn configuration() -> Configuration {
    let mut config = Configuration::default();
    config.basic_auth = read_credentials();
    config
}

fn read_credentials() -> Option<BasicAuth> {
    let home = dirs::home_dir().expect("Unable to find home directory");
    let creds = home.join(".hahabit.toml");
    let contents = fs::read_to_string(&creds).expect("Unable to read file");
    let toml = contents.parse::<Table>().unwrap();

    // lol what is this
    Some((toml["username"].clone().try_into().unwrap(), Some(toml["password"].clone().try_into().unwrap())))
}
