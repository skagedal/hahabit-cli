/*
 * Hahabit API
 * API for the Hahabit Habit Tracker
 *
 * The version of the OpenAPI document: 0.1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package tech.skagedal.hahabit.generated.api;

import tech.skagedal.hahabit.generated.invoker.ApiClient;
import tech.skagedal.hahabit.generated.invoker.ApiException;
import tech.skagedal.hahabit.generated.invoker.ApiResponse;
import tech.skagedal.hahabit.generated.invoker.Pair;

import tech.skagedal.hahabit.generated.model.GetHabits200Response;
import tech.skagedal.hahabit.generated.model.GetHabitsForDate200Response;
import tech.skagedal.hahabit.generated.model.HabitCreateRequest;
import java.time.LocalDate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.http.HttpRequest;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class HahabitApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;
  private final Consumer<HttpResponse<String>> memberVarAsyncResponseInterceptor;

  public HahabitApi() {
    this(new ApiClient());
  }

  public HahabitApi(ApiClient apiClient) {
    memberVarHttpClient = apiClient.getHttpClient();
    memberVarObjectMapper = apiClient.getObjectMapper();
    memberVarBaseUri = apiClient.getBaseUri();
    memberVarInterceptor = apiClient.getRequestInterceptor();
    memberVarReadTimeout = apiClient.getReadTimeout();
    memberVarResponseInterceptor = apiClient.getResponseInterceptor();
    memberVarAsyncResponseInterceptor = apiClient.getAsyncResponseInterceptor();
  }

  protected ApiException getApiException(String operationId, HttpResponse<InputStream> response) throws IOException {
    String body = response.body() == null ? null : new String(response.body().readAllBytes());
    String message = formatExceptionMessage(operationId, response.statusCode(), body);
    return new ApiException(response.statusCode(), message, response.headers(), body);
  }

  private String formatExceptionMessage(String operationId, int statusCode, String body) {
    if (body == null || body.isEmpty()) {
      body = "[no body]";
    }
    return operationId + " call failed with: " + statusCode + " - " + body;
  }

  /**
   * Create a new habit
   * Create a new habit
   * @param habitCreateRequest  (required)
   * @return Object
   * @throws ApiException if fails to make API call
   */
  public Object createHabit(HabitCreateRequest habitCreateRequest) throws ApiException {
    ApiResponse<Object> localVarResponse = createHabitWithHttpInfo(habitCreateRequest);
    return localVarResponse.getData();
  }

  /**
   * Create a new habit
   * Create a new habit
   * @param habitCreateRequest  (required)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Object> createHabitWithHttpInfo(HabitCreateRequest habitCreateRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = createHabitRequestBuilder(habitCreateRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("createHabit", localVarResponse);
        }
        return new ApiResponse<Object>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Object>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder createHabitRequestBuilder(HabitCreateRequest habitCreateRequest) throws ApiException {
    // verify the required parameter 'habitCreateRequest' is set
    if (habitCreateRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'habitCreateRequest' when calling createHabit");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/habits";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(habitCreateRequest);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Get all habits
   * Get all habits
   * @return GetHabits200Response
   * @throws ApiException if fails to make API call
   */
  public GetHabits200Response getHabits() throws ApiException {
    ApiResponse<GetHabits200Response> localVarResponse = getHabitsWithHttpInfo();
    return localVarResponse.getData();
  }

  /**
   * Get all habits
   * Get all habits
   * @return ApiResponse&lt;GetHabits200Response&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<GetHabits200Response> getHabitsWithHttpInfo() throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getHabitsRequestBuilder();
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getHabits", localVarResponse);
        }
        return new ApiResponse<GetHabits200Response>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<GetHabits200Response>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getHabitsRequestBuilder() throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/habits";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Get all habits for a specific date
   * Get all habits for a specific date
   * @param date The date to get habits for (required)
   * @return GetHabitsForDate200Response
   * @throws ApiException if fails to make API call
   */
  public GetHabitsForDate200Response getHabitsForDate(LocalDate date) throws ApiException {
    ApiResponse<GetHabitsForDate200Response> localVarResponse = getHabitsForDateWithHttpInfo(date);
    return localVarResponse.getData();
  }

  /**
   * Get all habits for a specific date
   * Get all habits for a specific date
   * @param date The date to get habits for (required)
   * @return ApiResponse&lt;GetHabitsForDate200Response&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<GetHabitsForDate200Response> getHabitsForDateWithHttpInfo(LocalDate date) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getHabitsForDateRequestBuilder(date);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getHabitsForDate", localVarResponse);
        }
        return new ApiResponse<GetHabitsForDate200Response>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<GetHabitsForDate200Response>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getHabitsForDateRequestBuilder(LocalDate date) throws ApiException {
    // verify the required parameter 'date' is set
    if (date == null) {
      throw new ApiException(400, "Missing the required parameter 'date' when calling getHabitsForDate");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/habits/{date}"
        .replace("{date}", ApiClient.urlEncode(date.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Track a habit for a specific date
   * Track a habit for a specific date
   * @param date The date to track the habit for (required)
   * @param habitId The habit to track (required)
   * @return Object
   * @throws ApiException if fails to make API call
   */
  public Object trackHabit(LocalDate date, Long habitId) throws ApiException {
    ApiResponse<Object> localVarResponse = trackHabitWithHttpInfo(date, habitId);
    return localVarResponse.getData();
  }

  /**
   * Track a habit for a specific date
   * Track a habit for a specific date
   * @param date The date to track the habit for (required)
   * @param habitId The habit to track (required)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Object> trackHabitWithHttpInfo(LocalDate date, Long habitId) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = trackHabitRequestBuilder(date, habitId);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("trackHabit", localVarResponse);
        }
        return new ApiResponse<Object>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Object>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder trackHabitRequestBuilder(LocalDate date, Long habitId) throws ApiException {
    // verify the required parameter 'date' is set
    if (date == null) {
      throw new ApiException(400, "Missing the required parameter 'date' when calling trackHabit");
    }
    // verify the required parameter 'habitId' is set
    if (habitId == null) {
      throw new ApiException(400, "Missing the required parameter 'habitId' when calling trackHabit");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/habits/{date}/{habitId}/track"
        .replace("{date}", ApiClient.urlEncode(date.toString()))
        .replace("{habitId}", ApiClient.urlEncode(habitId.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
}
