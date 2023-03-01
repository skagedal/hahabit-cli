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


package tech.skagedal.hahabit.generated.model;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;
import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;
import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * HabitForDate
 */
@JsonPropertyOrder({
  HabitForDate.JSON_PROPERTY_HABIT_ID,
  HabitForDate.JSON_PROPERTY_DESCRIPTION,
  HabitForDate.JSON_PROPERTY_DATE,
  HabitForDate.JSON_PROPERTY_TRACKING_ID
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-03-01T21:30:38.032618+01:00[Europe/Stockholm]")
public class HabitForDate {
  public static final String JSON_PROPERTY_HABIT_ID = "habitId";
  private Long habitId;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_DATE = "date";
  private LocalDate date;

  public static final String JSON_PROPERTY_TRACKING_ID = "trackingId";
  private JsonNullable<Long> trackingId = JsonNullable.<Long>undefined();

  public HabitForDate() { 
  }

  public HabitForDate habitId(Long habitId) {
    this.habitId = habitId;
    return this;
  }

   /**
   * Get habitId
   * @return habitId
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_HABIT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getHabitId() {
    return habitId;
  }


  @JsonProperty(JSON_PROPERTY_HABIT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHabitId(Long habitId) {
    this.habitId = habitId;
  }


  public HabitForDate description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(String description) {
    this.description = description;
  }


  public HabitForDate date(LocalDate date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LocalDate getDate() {
    return date;
  }


  @JsonProperty(JSON_PROPERTY_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDate(LocalDate date) {
    this.date = date;
  }


  public HabitForDate trackingId(Long trackingId) {
    this.trackingId = JsonNullable.<Long>of(trackingId);
    return this;
  }

   /**
   * Get trackingId
   * @return trackingId
  **/
  @javax.annotation.Nullable
  @JsonIgnore

  public Long getTrackingId() {
        return trackingId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TRACKING_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Long> getTrackingId_JsonNullable() {
    return trackingId;
  }
  
  @JsonProperty(JSON_PROPERTY_TRACKING_ID)
  public void setTrackingId_JsonNullable(JsonNullable<Long> trackingId) {
    this.trackingId = trackingId;
  }

  public void setTrackingId(Long trackingId) {
    this.trackingId = JsonNullable.<Long>of(trackingId);
  }


  /**
   * Return true if this HabitForDate object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HabitForDate habitForDate = (HabitForDate) o;
    return Objects.equals(this.habitId, habitForDate.habitId) &&
        Objects.equals(this.description, habitForDate.description) &&
        Objects.equals(this.date, habitForDate.date) &&
        equalsNullable(this.trackingId, habitForDate.trackingId);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(habitId, description, date, hashCodeNullable(trackingId));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HabitForDate {\n");
    sb.append("    habitId: ").append(toIndentedString(habitId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    trackingId: ").append(toIndentedString(trackingId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Convert the instance into URL query string.
   *
   * @return URL query string
   */
  public String toUrlQueryString() {
    return toUrlQueryString(null);
  }

  /**
   * Convert the instance into URL query string.
   *
   * @param prefix prefix of the query string
   * @return URL query string
   */
  public String toUrlQueryString(String prefix) {
    String suffix = "";
    String containerSuffix = "";
    String containerPrefix = "";
    if (prefix == null) {
      // style=form, explode=true, e.g. /pet?name=cat&type=manx
      prefix = "";
    } else {
      // deepObject style e.g. /pet?id[name]=cat&id[type]=manx
      prefix = prefix + "[";
      suffix = "]";
      containerSuffix = "]";
      containerPrefix = "[";
    }

    StringJoiner joiner = new StringJoiner("&");

    // add `habitId` to the URL query string
    if (getHabitId() != null) {
      joiner.add(String.format("%shabitId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getHabitId()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `description` to the URL query string
    if (getDescription() != null) {
      joiner.add(String.format("%sdescription%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getDescription()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `date` to the URL query string
    if (getDate() != null) {
      joiner.add(String.format("%sdate%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getDate()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `trackingId` to the URL query string
    if (getTrackingId() != null) {
      joiner.add(String.format("%strackingId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getTrackingId()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    return joiner.toString();
  }
}

