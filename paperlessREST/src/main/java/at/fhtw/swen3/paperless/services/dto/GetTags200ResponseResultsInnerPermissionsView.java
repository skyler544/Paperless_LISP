package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** GetTags200ResponseResultsInnerPermissionsView */
@Setter
@JsonTypeName("GetTags_200_response_results_inner_permissions_view")
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-11-03T13:46:03.125613Z[Etc/UTC]")
public class GetTags200ResponseResultsInnerPermissionsView {

    @Valid private List<Object> users = new ArrayList<>();

    @Valid private List<Object> groups = new ArrayList<>();

    /**
     * Get users
     *
     * @return users
     */
    @NotNull
    @Schema(name = "users", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("users")
    public List<Object> getUsers() {
        return users;
    }

    /**
     * Get groups
     *
     * @return groups
     */
    @NotNull
    @Schema(name = "groups", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("groups")
    public List<Object> getGroups() {
        return groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetTags200ResponseResultsInnerPermissionsView
                getTags200ResponseResultsInnerPermissionsView =
                        (GetTags200ResponseResultsInnerPermissionsView) o;
        return Objects.equals(this.users, getTags200ResponseResultsInnerPermissionsView.users)
                && Objects.equals(
                        this.groups, getTags200ResponseResultsInnerPermissionsView.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users, groups);
    }

    @Override
    public String toString() {
        return "class GetTags200ResponseResultsInnerPermissionsView {\n"
                + "    users: "
                + toIndentedString(users)
                + "\n"
                + "    groups: "
                + toIndentedString(groups)
                + "\n"
                + "}";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first
     * line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
