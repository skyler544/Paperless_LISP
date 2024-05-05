package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonTypeName("CreateUISettings_request_settings")
public class CreateUISettingsRequestSettings {
    @NotNull
    @Valid
    @JsonProperty("update_checking")
    private CreateUISettingsRequestSettingsUpdateChecking updateChecking;
}
