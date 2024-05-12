package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonTypeName("CreateUISettings_request_settings_update_checking")
public class CreateUISettingsRequestSettingsUpdateChecking {
    @JsonProperty("backend_setting")
    private String backendSetting;

    @NotNull
    @JsonProperty("enabled")
    private Boolean enabled;
}
