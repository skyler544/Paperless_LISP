package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonTypeName("Statistics_200_response")
public class Statistics200Response {
    @NotNull
    @JsonProperty("documents_total")
    private Integer documentsTotal;

    @NotNull
    @JsonProperty("documents_inbox")
    private Integer documentsInbox;

    @NotNull
    @JsonProperty("inbox_tag")
    private Integer inboxTag;

    @NotNull
    @JsonProperty("character_count")
    private Integer characterCount;

    public Statistics200Response() {
        super();
    }
}
