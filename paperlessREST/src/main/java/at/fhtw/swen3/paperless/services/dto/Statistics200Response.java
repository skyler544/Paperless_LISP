package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonTypeName("Statistics_200_response")
public class Statistics200Response {
    @NotNull
    @Schema(name = "documents_total", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("documents_total")
    private Integer documentsTotal;

    @NotNull
    @Schema(name = "documents_inbox", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("documents_inbox")
    private Integer documentsInbox;

    @NotNull
    @Schema(name = "inbox_tag", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("inbox_tag")
    private Integer inboxTag;

    @NotNull
    @Schema(name = "character_count", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("character_count")
    private Integer characterCount;

    public Statistics200Response() {
        super();
    }
}
