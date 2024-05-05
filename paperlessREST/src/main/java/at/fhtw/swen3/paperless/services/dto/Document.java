package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;

import lombok.Setter;

import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Setter
public class Document {

    private Integer id;

    private JsonNullable<Integer> correspondent = JsonNullable.undefined();

    private JsonNullable<Integer> documentType = JsonNullable.undefined();

    private JsonNullable<Integer> storagePath = JsonNullable.undefined();

    private JsonNullable<String> title = JsonNullable.undefined();

    private JsonNullable<String> content = JsonNullable.undefined();

    @Valid private JsonNullable<List<Integer>> tags = JsonNullable.undefined();

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime created;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime createdDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime modified;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime added;

    private JsonNullable<String> archiveSerialNumber = JsonNullable.undefined();

    private JsonNullable<String> originalFileName = JsonNullable.undefined();

    private JsonNullable<String> archivedFileName = JsonNullable.undefined();

    /**
     * Get id
     *
     * @return id
     */
    @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * Get correspondent
     *
     * @return correspondent
     */
    @Schema(name = "correspondent", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("correspondent")
    public JsonNullable<Integer> getCorrespondent() {
        return correspondent;
    }

    /**
     * Get documentType
     *
     * @return documentType
     */
    @Schema(name = "document_type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("document_type")
    public JsonNullable<Integer> getDocumentType() {
        return documentType;
    }

    /**
     * Get storagePath
     *
     * @return storagePath
     */
    @Schema(name = "storage_path", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("storage_path")
    public JsonNullable<Integer> getStoragePath() {
        return storagePath;
    }

    /**
     * Get title
     *
     * @return title
     */
    @Schema(name = "title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("title")
    public JsonNullable<String> getTitle() {
        return title;
    }

    /**
     * Get content
     *
     * @return content
     */
    @Schema(name = "content", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("content")
    public JsonNullable<String> getContent() {
        return content;
    }

    /**
     * Get tags
     *
     * @return tags
     */
    @Schema(name = "tags", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("tags")
    public JsonNullable<List<Integer>> getTags() {
        return tags;
    }

    /**
     * Get created
     *
     * @return created
     */
    @Valid
    @Schema(name = "created", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("created")
    public OffsetDateTime getCreated() {
        return created;
    }

    /**
     * Get createdDate
     *
     * @return createdDate
     */
    @Valid
    @Schema(name = "created_date", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("created_date")
    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * Get modified
     *
     * @return modified
     */
    @Valid
    @Schema(name = "modified", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("modified")
    public OffsetDateTime getModified() {
        return modified;
    }

    /**
     * Get added
     *
     * @return added
     */
    @Valid
    @Schema(name = "added", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("added")
    public OffsetDateTime getAdded() {
        return added;
    }

    /**
     * Get archiveSerialNumber
     *
     * @return archiveSerialNumber
     */
    @Schema(name = "archive_serial_number", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("archive_serial_number")
    public JsonNullable<String> getArchiveSerialNumber() {
        return archiveSerialNumber;
    }

    /**
     * Get originalFileName
     *
     * @return originalFileName
     */
    @Schema(name = "original_file_name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("original_file_name")
    public JsonNullable<String> getOriginalFileName() {
        return originalFileName;
    }

    /**
     * Get archivedFileName
     *
     * @return archivedFileName
     */
    @Schema(name = "archived_file_name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("archived_file_name")
    public JsonNullable<String> getArchivedFileName() {
        return archivedFileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Document document = (Document) o;
        return Objects.equals(this.id, document.id)
                && equalsNullable(this.correspondent, document.correspondent)
                && equalsNullable(this.documentType, document.documentType)
                && equalsNullable(this.storagePath, document.storagePath)
                && equalsNullable(this.title, document.title)
                && equalsNullable(this.content, document.content)
                && equalsNullable(this.tags, document.tags)
                && Objects.equals(this.created, document.created)
                && Objects.equals(this.createdDate, document.createdDate)
                && Objects.equals(this.modified, document.modified)
                && Objects.equals(this.added, document.added)
                && equalsNullable(this.archiveSerialNumber, document.archiveSerialNumber)
                && equalsNullable(this.originalFileName, document.originalFileName)
                && equalsNullable(this.archivedFileName, document.archivedFileName);
    }

    private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
        return a == b
                || (a != null
                        && b != null
                        && a.isPresent()
                        && b.isPresent()
                        && Objects.deepEquals(a.get(), b.get()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                hashCodeNullable(correspondent),
                hashCodeNullable(documentType),
                hashCodeNullable(storagePath),
                hashCodeNullable(title),
                hashCodeNullable(content),
                hashCodeNullable(tags),
                created,
                createdDate,
                modified,
                added,
                hashCodeNullable(archiveSerialNumber),
                hashCodeNullable(originalFileName),
                hashCodeNullable(archivedFileName));
    }

    private static <T> int hashCodeNullable(JsonNullable<T> a) {
        if (a == null) {
            return 1;
        }
        return a.isPresent() ? Arrays.deepHashCode(new Object[] {a.get()}) : 31;
    }

    @Override
    public String toString() {
        return "class Document {\n"
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
                + "    created: "
                + toIndentedString(created)
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
