package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

import lombok.Setter;

import java.util.Objects;

/** GetDocuments200ResponseResultsInnerNotesInner */
@Setter
@JsonTypeName("GetDocuments_200_response_results_inner_notes_inner")
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
public class GetDocuments200ResponseResultsInnerNotesInner {

    private Integer id;

    private String note;

    private String created;

    private Integer document;

    private Integer user;

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
     * Get note
     *
     * @return note
     */
    @NotNull
    @Schema(name = "note", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("note")
    public String getNote() {
        return note;
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
     * Get document
     *
     * @return document
     */
    @NotNull
    @Schema(name = "document", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("document")
    public Integer getDocument() {
        return document;
    }

    /**
     * Get user
     *
     * @return user
     */
    @NotNull
    @Schema(name = "user", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("user")
    public Integer getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetDocuments200ResponseResultsInnerNotesInner
                getDocuments200ResponseResultsInnerNotesInner =
                        (GetDocuments200ResponseResultsInnerNotesInner) o;
        return Objects.equals(this.id, getDocuments200ResponseResultsInnerNotesInner.id)
                && Objects.equals(this.note, getDocuments200ResponseResultsInnerNotesInner.note)
                && Objects.equals(
                        this.created, getDocuments200ResponseResultsInnerNotesInner.created)
                && Objects.equals(
                        this.document, getDocuments200ResponseResultsInnerNotesInner.document)
                && Objects.equals(this.user, getDocuments200ResponseResultsInnerNotesInner.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, note, created, document, user);
    }

    @Override
    public String toString() {
        return "class GetDocuments200ResponseResultsInnerNotesInner {\n"
                + "    id: "
                + toIndentedString(id)
                + "\n"
                + "    note: "
                + toIndentedString(note)
                + "\n"
                + "    created: "
                + toIndentedString(created)
                + "\n"
                + "    document: "
                + toIndentedString(document)
                + "\n"
                + "    user: "
                + toIndentedString(user)
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
