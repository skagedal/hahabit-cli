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
import java.util.ArrayList;
import java.util.List;
import tech.skagedal.hahabit.generated.model.Habit;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * GetHabits200Response
 */
@JsonPropertyOrder({
  GetHabits200Response.JSON_PROPERTY_HABITS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-03-03T16:56:46.112917+01:00[Europe/Stockholm]")
public class GetHabits200Response {
  public static final String JSON_PROPERTY_HABITS = "habits";
  private List<Habit> habits = new ArrayList<>();

  public GetHabits200Response() { 
  }

  public GetHabits200Response habits(List<Habit> habits) {
    this.habits = habits;
    return this;
  }

  public GetHabits200Response addHabitsItem(Habit habitsItem) {
    if (this.habits == null) {
      this.habits = new ArrayList<>();
    }
    this.habits.add(habitsItem);
    return this;
  }

   /**
   * Get habits
   * @return habits
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_HABITS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Habit> getHabits() {
    return habits;
  }


  @JsonProperty(JSON_PROPERTY_HABITS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHabits(List<Habit> habits) {
    this.habits = habits;
  }


  /**
   * Return true if this getHabits_200_response object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetHabits200Response getHabits200Response = (GetHabits200Response) o;
    return Objects.equals(this.habits, getHabits200Response.habits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(habits);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetHabits200Response {\n");
    sb.append("    habits: ").append(toIndentedString(habits)).append("\n");
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

    // add `habits` to the URL query string
    if (getHabits() != null) {
      for (int i = 0; i < getHabits().size(); i++) {
        if (getHabits().get(i) != null) {
          joiner.add(getHabits().get(i).toUrlQueryString(String.format("%shabits%s%s", prefix, suffix,
          "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    return joiner.toString();
  }
}

