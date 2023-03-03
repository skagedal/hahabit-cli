# \HahabitApi

All URIs are relative to *https://hahabit.skagedal.tech/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_habit**](HahabitApi.md#create_habit) | **POST** /habits | Create a new habit
[**get_habits**](HahabitApi.md#get_habits) | **GET** /habits | Get all habits
[**get_habits_for_date**](HahabitApi.md#get_habits_for_date) | **GET** /habits/{date} | Get all habits for a specific date
[**track_habit**](HahabitApi.md#track_habit) | **POST** /habits/{date}/{habitId}/track | Track a habit for a specific date



## create_habit

> serde_json::Value create_habit(habit_create_request)
Create a new habit

Create a new habit

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**habit_create_request** | [**HabitCreateRequest**](HabitCreateRequest.md) |  | [required] |

### Return type

[**serde_json::Value**](serde_json::Value.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## get_habits

> crate::models::GetHabits200Response get_habits()
Get all habits

Get all habits

### Parameters

This endpoint does not need any parameter.

### Return type

[**crate::models::GetHabits200Response**](getHabits_200_response.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## get_habits_for_date

> crate::models::GetHabitsForDate200Response get_habits_for_date(date)
Get all habits for a specific date

Get all habits for a specific date

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**date** | **String** | The date to get habits for | [required] |

### Return type

[**crate::models::GetHabitsForDate200Response**](getHabitsForDate_200_response.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## track_habit

> serde_json::Value track_habit(date, habit_id)
Track a habit for a specific date

Track a habit for a specific date

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**date** | **String** | The date to track the habit for | [required] |
**habit_id** | **i64** | The habit to track | [required] |

### Return type

[**serde_json::Value**](serde_json::Value.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

