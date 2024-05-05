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
@JsonTypeName("CreateUISettings_request")
public class CreateUISettingsRequest {
    @NotNull
    @Valid
    @Schema(name = "settings", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("settings")
    private CreateUISettingsRequestSettings settings;
}
