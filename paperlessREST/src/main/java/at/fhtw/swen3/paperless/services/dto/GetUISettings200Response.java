package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** GetUISettings200Response */
@Setter
@JsonTypeName("GetUISettings_200_response")
public class GetUISettings200Response {

    private String displayName;

    @Valid private List<String> permissions = new ArrayList<>();

    public GetUISettings200Response() {
        super();
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
        return "class GetUISettings200Response {\n"
                + "    displayName: "
                + toIndentedString(displayName)
                + "\n"
                + "    permissions: "
                + toIndentedString(permissions)
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
