package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

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
    @Schema(name = "update_checking", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("update_checking")
    private CreateUISettingsRequestSettingsUpdateChecking updateChecking;
}
