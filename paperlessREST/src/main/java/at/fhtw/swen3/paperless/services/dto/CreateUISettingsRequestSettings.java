package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import lombok.Setter;

import java.util.Objects;

/** CreateUISettingsRequestSettings */
@Setter
@JsonTypeName("CreateUISettings_request_settings")
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-11-15T14:45:09.395474Z[Etc/UTC]")
public class CreateUISettingsRequestSettings {

    private CreateUISettingsRequestSettingsUpdateChecking updateChecking;

    /**
     * Get updateChecking
     *
     * @return updateChecking
     */
    @NotNull
    @Valid
    @Schema(name = "update_checking", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("update_checking")
    public CreateUISettingsRequestSettingsUpdateChecking getUpdateChecking() {
        return updateChecking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateUISettingsRequestSettings createUISettingsRequestSettings =
                (CreateUISettingsRequestSettings) o;
        return Objects.equals(this.updateChecking, createUISettingsRequestSettings.updateChecking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(updateChecking);
    }

    @Override
    public String toString() {
        return "class CreateUISettingsRequestSettings {\n"
                + "    updateChecking: "
                + toIndentedString(updateChecking)
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
