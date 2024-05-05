package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

import lombok.Setter;

import java.util.Objects;

/** CreateUISettingsRequestSettingsUpdateChecking */
@Setter
@JsonTypeName("CreateUISettings_request_settings_update_checking")
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
public class CreateUISettingsRequestSettingsUpdateChecking {

    private String backendSetting;

    private Boolean enabled;

    /**
     * Get backendSetting
     *
     * @return backendSetting
     */
    // @NotNull
    @Schema(name = "backend_setting", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("backend_setting")
    public String getBackendSetting() {
        return backendSetting;
    }

    /**
     * Get enabled
     *
     * @return enabled
     */
    @NotNull
    @Schema(name = "enabled", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateUISettingsRequestSettingsUpdateChecking
                createUISettingsRequestSettingsUpdateChecking =
                        (CreateUISettingsRequestSettingsUpdateChecking) o;
        return Objects.equals(
                        this.backendSetting,
                        createUISettingsRequestSettingsUpdateChecking.backendSetting)
                && Objects.equals(
                        this.enabled, createUISettingsRequestSettingsUpdateChecking.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(backendSetting, enabled);
    }

    @Override
    public String toString() {
        return "class CreateUISettingsRequestSettingsUpdateChecking {\n"
                + "    backendSetting: "
                + toIndentedString(backendSetting)
                + "\n"
                + "    enabled: "
                + toIndentedString(enabled)
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
