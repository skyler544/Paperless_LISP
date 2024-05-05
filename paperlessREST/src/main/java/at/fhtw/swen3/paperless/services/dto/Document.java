package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;

import lombok.Getter;
import lombok.Setter;

import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.List;

@Setter
@Getter
public class Document {
    @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("id")
    private Integer id;

    @Schema(name = "correspondent", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("correspondent")
    private JsonNullable<Integer> correspondent = JsonNullable.undefined();

    @Schema(name = "document_type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("document_type")
    private JsonNullable<Integer> documentType = JsonNullable.undefined();

    @Schema(name = "storage_path", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("storage_path")
    private JsonNullable<Integer> storagePath = JsonNullable.undefined();

    @Schema(name = "title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("title")
    private JsonNullable<String> title = JsonNullable.undefined();

    @Schema(name = "content", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("content")
    private JsonNullable<String> content = JsonNullable.undefined();

    @Valid
    @Schema(name = "tags", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("tags")
    private JsonNullable<List<Integer>> tags = JsonNullable.undefined();

    @Valid
    @Schema(name = "created", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("created")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime created;

    @Valid
    @Schema(name = "created_date", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("created_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime createdDate;

    @Valid
    @Schema(name = "modified", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("modified")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime modified;

    @Valid
    @Schema(name = "added", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("added")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime added;

    @Schema(name = "archive_serial_number", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("archive_serial_number")
    private JsonNullable<String> archiveSerialNumber = JsonNullable.undefined();

    @Schema(name = "original_file_name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("original_file_name")
    private JsonNullable<String> originalFileName = JsonNullable.undefined();

    @Schema(name = "archived_file_name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("archived_file_name")
    private JsonNullable<String> archivedFileName = JsonNullable.undefined();
}
