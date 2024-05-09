package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonTypeName("HTTP_200_Response")
public class Http200Response {
    @NotNull
    @JsonProperty("success")
    private Boolean success;

    public Http200Response() {
        super();
    }
}
