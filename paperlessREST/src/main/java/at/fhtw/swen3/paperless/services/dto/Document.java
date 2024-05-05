package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Document {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("document_type")
    private String documentType;

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonProperty("created_date")
    private String createdDate;
}
