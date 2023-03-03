use std::fs;
use termion::raw::IntoRawMode;
use termion::event::Key;
use termion::input::TermRead;
use std::io::{Write, stdout, stdin};
use openapi::apis::configuration::{BasicAuth, Configuration};
use openapi::apis::{hahabit_api};
use tokio;
use toml::Table;

extern crate termion;

fn main() {
    sync_get_habits();

    let stdin = stdin();
    let mut stdout = stdout().into_raw_mode().unwrap();

    let lines = vec!["One", "Two", "three"];

    let mut first = true;
    for line in &lines {
        if !first {
            write!(stdout, "\r\n").unwrap();
        }
        write!(stdout, "🔳️ {}", line).unwrap();
        first = false;
    }

    let distance: u16 = (lines.len() - 1).try_into().unwrap();
    write!(stdout, "\r{}", termion::cursor::Up(distance)).unwrap();

    stdout.flush().unwrap();

    let mut current = 0;
    let max = lines.len() - 1;

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
                write!(stdout, "✅\r").unwrap();
            }
            _ => {}
        }

        stdout.flush().unwrap();
    }

    write!(stdout, "{}\r\n", termion::cursor::Down((max - current) as u16)).unwrap();
}


#[tokio::main]
async fn sync_get_habits() {
    let config = configuration();
    let response = hahabit_api::get_habits_for_date(&config, "2020-12-01".to_string()).await;
    println!("{:?}", response);
}

fn configuration() -> Configuration {
    let mut config = Configuration::default();
    let creds = read_credentials();
    println!("{:?}", creds);
    config.basic_auth = creds;
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
