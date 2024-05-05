package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Setter
@JsonTypeName("UpdateDocument_request")
public class UpdateDocumentRequest {

    private Integer id;

    private Integer correspondent;

    private Integer documentType;

    private Integer storagePath;

    private String title;

    private String content;

    @Valid private List<Integer> tags = new ArrayList<>();

    private String createdDate;

    private String modified;

    private String added;

    private Integer archiveSerialNumber;

    private String originalFileName;

    private String archivedFileName;

    private Integer owner;

    @Valid private List<Object> notes = new ArrayList<>();

    /**
     * Get id
     *
     * @return id
     */
    @NotNull
    @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * Get correspondent
     *
     * @return correspondent
     */
    @NotNull
    @Schema(name = "correspondent", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("correspondent")
    public Integer getCorrespondent() {
        return correspondent;
    }

    /**
     * Get documentType
     *
     * @return documentType
     */
    @NotNull
    @Schema(name = "document_type", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("document_type")
    public Integer getDocumentType() {
        return documentType;
    }

    /**
     * Get storagePath
     *
     * @return storagePath
     */
    @NotNull
    @Schema(name = "storage_path", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("storage_path")
    public Integer getStoragePath() {
        return storagePath;
    }

    /**
     * Get title
     *
     * @return title
     */
    @NotNull
    @Schema(name = "title", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * Get content
     *
     * @return content
     */
    @NotNull
    @Schema(name = "content", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * Get tags
     *
     * @return tags
     */
    @NotNull
    @Schema(name = "tags", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("tags")
    public List<Integer> getTags() {
        return tags;
    }

    /**
     * Get createdDate
     *
     * @return createdDate
     */
    @NotNull
    @Schema(name = "created_date", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("created_date")
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * Get modified
     *
     * @return modified
     */
    @NotNull
    @Schema(name = "modified", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("modified")
    public String getModified() {
        return modified;
    }

    /**
     * Get added
     *
     * @return added
     */
    @NotNull
    @Schema(name = "added", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("added")
    public String getAdded() {
        return added;
    }

    /**
     * Get archiveSerialNumber
     *
     * @return archiveSerialNumber
     */
    @NotNull
    @Schema(name = "archive_serial_number", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("archive_serial_number")
    public Integer getArchiveSerialNumber() {
        return archiveSerialNumber;
    }

    /**
     * Get originalFileName
     *
     * @return originalFileName
     */
    @NotNull
    @Schema(name = "original_file_name", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("original_file_name")
    public String getOriginalFileName() {
        return originalFileName;
    }

    /**
     * Get archivedFileName
     *
     * @return archivedFileName
     */
    @NotNull
    @Schema(name = "archived_file_name", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("archived_file_name")
    public String getArchivedFileName() {
        return archivedFileName;
    }

    /**
     * Get owner
     *
     * @return owner
     */
    @NotNull
    @Schema(name = "owner", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("owner")
    public Integer getOwner() {
        return owner;
    }

    /**
     * Get notes
     *
     * @return notes
     */
    @NotNull
    @Schema(name = "notes", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("notes")
    public List<Object> getNotes() {
        return notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateDocumentRequest updateDocumentRequest = (UpdateDocumentRequest) o;
        return Objects.equals(this.id, updateDocumentRequest.id)
                && Objects.equals(this.correspondent, updateDocumentRequest.correspondent)
                && Objects.equals(this.documentType, updateDocumentRequest.documentType)
                && Objects.equals(this.storagePath, updateDocumentRequest.storagePath)
                && Objects.equals(this.title, updateDocumentRequest.title)
                && Objects.equals(this.content, updateDocumentRequest.content)
                && Objects.equals(this.tags, updateDocumentRequest.tags)
                && Objects.equals(this.createdDate, updateDocumentRequest.createdDate)
                && Objects.equals(this.modified, updateDocumentRequest.modified)
                && Objects.equals(this.added, updateDocumentRequest.added)
                && Objects.equals(
                        this.archiveSerialNumber, updateDocumentRequest.archiveSerialNumber)
                && Objects.equals(this.originalFileName, updateDocumentRequest.originalFileName)
                && Objects.equals(this.archivedFileName, updateDocumentRequest.archivedFileName)
                && Objects.equals(this.owner, updateDocumentRequest.owner)
                && Objects.equals(this.notes, updateDocumentRequest.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                correspondent,
                documentType,
                storagePath,
                title,
                content,
                tags,
                createdDate,
                modified,
                added,
                archiveSerialNumber,
                originalFileName,
                archivedFileName,
                owner,
                notes);
    }

    @Override
    public String toString() {
        return "class UpdateDocumentRequest {\n"
                + "    id: "
                + toIndentedString(id)
                + "\n"
                + "    correspondent: "
                + toIndentedString(correspondent)
                + "\n"
                + "    documentType: "
                + toIndentedString(documentType)
                + "\n"
                + "    storagePath: "
                + toIndentedString(storagePath)
                + "\n"
                + "    title: "
                + toIndentedString(title)
                + "\n"
                + "    content: "
                + toIndentedString(content)
                + "\n"
                + "    tags: "
                + toIndentedString(tags)
                + "\n"
                + "    createdDate: "
                + toIndentedString(createdDate)
                + "\n"
                + "    modified: "
                + toIndentedString(modified)
                + "\n"
                + "    added: "
                + toIndentedString(added)
                + "\n"
                + "    archiveSerialNumber: "
                + toIndentedString(archiveSerialNumber)
                + "\n"
                + "    originalFileName: "
                + toIndentedString(originalFileName)
                + "\n"
                + "    archivedFileName: "
                + toIndentedString(archivedFileName)
                + "\n"
                + "    owner: "
                + toIndentedString(owner)
                + "\n"
                + "    notes: "
                + toIndentedString(notes)
                + "\n"
                + "}";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first
     * line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
