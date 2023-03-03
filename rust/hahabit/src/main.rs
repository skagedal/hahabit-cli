use termion::raw::IntoRawMode;
use termion::event::Key;
use termion::input::TermRead;
use std::io::{Write, stdout, stdin};
use openapi::apis::hahabit_api::HahabitApi;

extern crate termion;

fn main() {
    let api = HahabitApi::new();

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
