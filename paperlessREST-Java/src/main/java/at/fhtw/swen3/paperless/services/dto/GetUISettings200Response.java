package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

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
    @JsonProperty("display_name")
    private String displayName;

    @Valid
    @NotNull
    @JsonProperty("permissions")
    private List<String> permissions = new ArrayList<>();

    public GetUISettings200Response() {
        super();
    }
}
