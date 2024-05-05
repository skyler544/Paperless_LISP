package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@JsonTypeName("GetDocuments_200_response")
public class GetDocuments200Response {
    @NotNull
    @Schema(name = "count", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("count")
    private Integer count;

    @NotNull
    @Schema(name = "next", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("next")
    private Integer next;

    @NotNull
    @Schema(name = "previous", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("previous")
    private Integer previous;

    @Valid
    @NotNull
    @Schema(name = "all", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("all")
    private List<Integer> all = new ArrayList<>();

    @Valid
    @NotNull
    @Schema(name = "results", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("results")
    private List<@Valid GetDocuments200Response> results = new ArrayList<>();

    public GetDocuments200Response() {
        super();
    }
}
