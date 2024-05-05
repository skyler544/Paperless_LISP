package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonTypeName("CreateUISettings_request_settings_update_checking")
public class CreateUISettingsRequestSettingsUpdateChecking {
    @Schema(name = "backend_setting", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("backend_setting")
    private String backendSetting;

    @NotNull
    @Schema(name = "enabled", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("enabled")
    private Boolean enabled;
}
