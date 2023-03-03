/*
 * Hahabit API
 *
 * API for the Hahabit Habit Tracker
 *
 * The version of the OpenAPI document: 0.1.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, Serialize, Deserialize)]
pub struct GetHabitsForDate200Response {
    #[serde(rename = "habits", skip_serializing_if = "Option::is_none")]
    pub habits: Option<Vec<crate::models::HabitForDate>>,
}

impl GetHabitsForDate200Response {
    pub fn new() -> GetHabitsForDate200Response {
        GetHabitsForDate200Response {
            habits: None,
        }
    }
}


