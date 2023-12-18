package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * GetTags200ResponseResultsInnerPermissions
 */

@JsonTypeName("GetTags_200_response_results_inner_permissions")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-03T13:46:03.125613Z[Etc/UTC]")
public class GetTags200ResponseResultsInnerPermissions {

  private GetTags200ResponseResultsInnerPermissionsView view;

  private GetTags200ResponseResultsInnerPermissionsView change;

  public GetTags200ResponseResultsInnerPermissions() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GetTags200ResponseResultsInnerPermissions(GetTags200ResponseResultsInnerPermissionsView view, GetTags200ResponseResultsInnerPermissionsView change) {
    this.view = view;
    this.change = change;
  }

  public GetTags200ResponseResultsInnerPermissions view(GetTags200ResponseResultsInnerPermissionsView view) {
    this.view = view;
    return this;
  }

  /**
   * Get view
   * @return view
  */
  @NotNull @Valid 
  @Schema(name = "view", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("view")
  public GetTags200ResponseResultsInnerPermissionsView getView() {
    return view;
  }

  public void setView(GetTags200ResponseResultsInnerPermissionsView view) {
    this.view = view;
  }

  public GetTags200ResponseResultsInnerPermissions change(GetTags200ResponseResultsInnerPermissionsView change) {
    this.change = change;
    return this;
  }

  /**
   * Get change
   * @return change
  */
  @NotNull @Valid 
  @Schema(name = "change", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("change")
  public GetTags200ResponseResultsInnerPermissionsView getChange() {
    return change;
  }

  public void setChange(GetTags200ResponseResultsInnerPermissionsView change) {
    this.change = change;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetTags200ResponseResultsInnerPermissions getTags200ResponseResultsInnerPermissions = (GetTags200ResponseResultsInnerPermissions) o;
    return Objects.equals(this.view, getTags200ResponseResultsInnerPermissions.view) &&
        Objects.equals(this.change, getTags200ResponseResultsInnerPermissions.change);
  }

  @Override
  public int hashCode() {
    return Objects.hash(view, change);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTags200ResponseResultsInnerPermissions {\n");
    sb.append("    view: ").append(toIndentedString(view)).append("\n");
    sb.append("    change: ").append(toIndentedString(change)).append("\n");
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
}

