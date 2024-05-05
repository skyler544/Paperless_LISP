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
@JsonTypeName("GetSavedViews_200_response")
public class GetSavedViews200Response {
    @NotNull
    @JsonProperty("count")
    private Integer count;

    @NotNull
    @JsonProperty("next")
    private Integer next;

    @NotNull
    @JsonProperty("previous")
    private Integer previous;

    @Valid
    @NotNull
    @JsonProperty("all")
    private List<Integer> all = new ArrayList<>();

    @NotNull
    @Valid
    @JsonProperty("results")
    private List<@Valid GetSavedViews200ResponseResultsInner> results = new ArrayList<>();

    public GetSavedViews200Response() {
        super();
    }
}
