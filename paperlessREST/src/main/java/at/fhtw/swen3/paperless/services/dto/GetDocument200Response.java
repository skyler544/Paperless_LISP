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
@JsonTypeName("GetDocument_200_response")
public class GetDocument200Response {
    @NotNull
    @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("id")
    private Integer id;

    @NotNull
    @Schema(name = "correspondent", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("correspondent")
    private Integer correspondent;

    @NotNull
    @Schema(name = "document_type", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("document_type")
    private Integer documentType;

    @NotNull
    @Schema(name = "storage_path", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("storage_path")
    private Integer storagePath;

    @NotNull
    @Schema(name = "title", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("title")
    private String title;

    @NotNull
    @Schema(name = "content", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("content")
    private String content;

    @Valid
    @NotNull
    @Schema(name = "tags", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("tags")
    private List<Integer> tags = new ArrayList<>();

    @NotNull
    @Schema(name = "created", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("created")
    private String created;

    @NotNull
    @Schema(name = "created_date", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("created_date")
    private String createdDate;

    @NotNull
    @Schema(name = "modified", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("modified")
    private String modified;

    @NotNull
    @Schema(name = "added", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("added")
    private String added;

    @NotNull
    @Schema(name = "archive_serial_number", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("archive_serial_number")
    private Integer archiveSerialNumber;

    @NotNull
    @Schema(name = "original_file_name", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("original_file_name")
    private String originalFileName;

    @NotNull
    @Schema(name = "archived_file_name", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("archived_file_name")
    private String archivedFileName;

    @NotNull
    @Schema(name = "owner", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("owner")
    private Integer owner;

    @NotNull
    @Valid
    @Schema(name = "permissions", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("permissions")
    private GetDocument200ResponsePermissions permissions;

    @NotNull
    @Valid
    @Schema(name = "notes", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("notes")
    private List<@Valid GetDocuments200ResponseResultsInnerNotesInner> notes = new ArrayList<>();

    public GetDocument200Response() {
        super();
    }
}
