package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** GetUISettings200Response */
@JsonTypeName("GetUISettings_200_response")
public class GetUISettings200Response {

    private String displayName;

    @Valid private List<String> permissions = new ArrayList<>();

    public GetUISettings200Response() {
        super();
    }

    /** Constructor with only required parameters */
    public GetUISettings200Response(String displayName, List<String> permissions) {
        this.displayName = displayName;
        this.permissions = permissions;
    }

    public GetUISettings200Response displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get displayName
     *
     * @return displayName
     */
    @NotNull
    @Schema(name = "display_name", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("display_name")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public GetUISettings200Response permissions(List<String> permissions) {
        this.permissions = permissions;
        return this;
    }

    public GetUISettings200Response addPermissionsItem(String permissionsItem) {
        if (this.permissions == null) {
            this.permissions = new ArrayList<>();
        }
        this.permissions.add(permissionsItem);
        return this;
    }

    /**
     * Get permissions
     *
     * @return permissions
     */
    @NotNull
    @Schema(name = "permissions", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("permissions")
    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetUISettings200Response getUISettings200Response = (GetUISettings200Response) o;
        return Objects.equals(this.displayName, getUISettings200Response.displayName)
                && Objects.equals(this.permissions, getUISettings200Response.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, permissions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetUISettings200Response {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
        sb.append("}");
        return sb.toString();
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
