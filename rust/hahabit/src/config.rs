use std::path::PathBuf;
use serde::Deserialize;

#[derive(Debug, Deserialize)]
pub struct Config {
    pub username: String,
    pub password: String
}

pub enum ConfigError {
    OpenFile(PathBuf, std::io::Error),
    InvalidFile
}

pub fn read_config() -> Result<Config, ConfigError> {
    let home = dirs::home_dir().expect("Unable to find home directory");
    let config_path = home.join(".hahabit.toml");
    let contents = std::fs::read_to_string(&config_path).map_err(|e| ConfigError::OpenFile(config_path, e))?;
    Ok(toml::from_str(&contents).map_err(|_| ConfigError::InvalidFile)?)
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn it_works() {
        let config: Config = toml::from_str(r"
            username = 'username'
            password = 'password'
        ").unwrap();

        assert_eq!(config.username, "username");
        assert_eq!(config.password, "password");
    }
}