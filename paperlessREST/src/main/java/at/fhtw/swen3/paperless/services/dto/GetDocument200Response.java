package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** GetDocument200Response */
@Setter
@JsonTypeName("GetDocument_200_response")
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
public class GetDocument200Response {

    private Integer id;

    private Integer correspondent;

    private Integer documentType;

    private Integer storagePath;

    private String title;

    private String content;

    @Valid private List<Integer> tags = new ArrayList<>();

    private String created;

    private String createdDate;

    private String modified;

    private String added;

    private Integer archiveSerialNumber;

    private String originalFileName;

    private String archivedFileName;

    private Integer owner;

    private GetDocument200ResponsePermissions permissions;

    @Valid
    private List<@Valid GetDocuments200ResponseResultsInnerNotesInner> notes = new ArrayList<>();

    public GetDocument200Response() {
        super();
    }

    /** Constructor with only required parameters */
    public GetDocument200Response(
            Integer id,
            Integer correspondent,
            Integer documentType,
            Integer storagePath,
            String title,
            String content,
            List<Integer> tags,
            String created,
            String createdDate,
            String modified,
            String added,
            Integer archiveSerialNumber,
            String originalFileName,
            String archivedFileName,
            Integer owner,
            GetDocument200ResponsePermissions permissions,
            List<@Valid GetDocuments200ResponseResultsInnerNotesInner> notes) {
        this.id = id;
        this.correspondent = correspondent;
        this.documentType = documentType;
        this.storagePath = storagePath;
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.created = created;
        this.createdDate = createdDate;
        this.modified = modified;
        this.added = added;
        this.archiveSerialNumber = archiveSerialNumber;
        this.originalFileName = originalFileName;
        this.archivedFileName = archivedFileName;
        this.owner = owner;
        this.permissions = permissions;
        this.notes = notes;
    }

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
     * Get created
     *
     * @return created
     */
    @NotNull
    @Schema(name = "created", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("created")
    public String getCreated() {
        return created;
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
     * Get permissions
     *
     * @return permissions
     */
    @NotNull
    @Valid
    @Schema(name = "permissions", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("permissions")
    public GetDocument200ResponsePermissions getPermissions() {
        return permissions;
    }

    /**
     * Get notes
     *
     * @return notes
     */
    @NotNull
    @Valid
    @Schema(name = "notes", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("notes")
    public List<@Valid GetDocuments200ResponseResultsInnerNotesInner> getNotes() {
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
        GetDocument200Response getDocument200Response = (GetDocument200Response) o;
        return Objects.equals(this.id, getDocument200Response.id)
                && Objects.equals(this.correspondent, getDocument200Response.correspondent)
                && Objects.equals(this.documentType, getDocument200Response.documentType)
                && Objects.equals(this.storagePath, getDocument200Response.storagePath)
                && Objects.equals(this.title, getDocument200Response.title)
                && Objects.equals(this.content, getDocument200Response.content)
                && Objects.equals(this.tags, getDocument200Response.tags)
                && Objects.equals(this.created, getDocument200Response.created)
                && Objects.equals(this.createdDate, getDocument200Response.createdDate)
                && Objects.equals(this.modified, getDocument200Response.modified)
                && Objects.equals(this.added, getDocument200Response.added)
                && Objects.equals(
                        this.archiveSerialNumber, getDocument200Response.archiveSerialNumber)
                && Objects.equals(this.originalFileName, getDocument200Response.originalFileName)
                && Objects.equals(this.archivedFileName, getDocument200Response.archivedFileName)
                && Objects.equals(this.owner, getDocument200Response.owner)
                && Objects.equals(this.permissions, getDocument200Response.permissions)
                && Objects.equals(this.notes, getDocument200Response.notes);
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
                created,
                createdDate,
                modified,
                added,
                archiveSerialNumber,
                originalFileName,
                archivedFileName,
                owner,
                permissions,
                notes);
    }

    @Override
    public String toString() {
        return "class GetDocument200Response {\n"
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
                + "    owner: "
                + toIndentedString(owner)
                + "\n"
                + "    permissions: "
                + toIndentedString(permissions)
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
