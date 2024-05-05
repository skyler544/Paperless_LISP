package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@JsonTypeName("GetUISettings_200_response")
public class GetUISettings200Response {

    @NotNull
    @Schema(name = "display_name", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("display_name")
    private String displayName;

    @Valid
    @NotNull
    @Schema(name = "permissions", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("permissions")
    private List<String> permissions = new ArrayList<>();

    public GetUISettings200Response() {
        super();
    }
}
