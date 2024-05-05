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

/** GetDocument200ResponsePermissionsView */
@Setter
@JsonTypeName("GetDocument_200_response_permissions_view")
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
public class GetDocument200ResponsePermissionsView {

    @Valid private List<Integer> users = new ArrayList<>();

    @Valid private List<Integer> groups = new ArrayList<>();

    /**
     * Get users
     *
     * @return users
     */
    @NotNull
    @Schema(name = "users", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("users")
    public List<Integer> getUsers() {
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
    public List<Integer> getGroups() {
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
        GetDocument200ResponsePermissionsView getDocument200ResponsePermissionsView =
                (GetDocument200ResponsePermissionsView) o;
        return Objects.equals(this.users, getDocument200ResponsePermissionsView.users)
                && Objects.equals(this.groups, getDocument200ResponsePermissionsView.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users, groups);
    }

    @Override
    public String toString() {
        return "class GetDocument200ResponsePermissionsView {\n"
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
