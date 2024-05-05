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

/** Statistics200Response */
@Setter
@JsonTypeName("Statistics_200_response")
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-11-03T12:56:46.892911Z[Etc/UTC]")
public class Statistics200Response {

    private Integer documentsTotal;

    private Integer documentsInbox;

    private Integer inboxTag;

    @Valid
    private List<@Valid Statistics200ResponseDocumentFileTypeCountsInner> documentFileTypeCounts =
            new ArrayList<>();

    private Integer characterCount;

    public Statistics200Response() {
        super();
    }

    /**
     * Get documentsTotal
     *
     * @return documentsTotal
     */
    @NotNull
    @Schema(name = "documents_total", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("documents_total")
    public Integer getDocumentsTotal() {
        return documentsTotal;
    }

    /**
     * Get documentsInbox
     *
     * @return documentsInbox
     */
    @NotNull
    @Schema(name = "documents_inbox", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("documents_inbox")
    public Integer getDocumentsInbox() {
        return documentsInbox;
    }

    /**
     * Get inboxTag
     *
     * @return inboxTag
     */
    @NotNull
    @Schema(name = "inbox_tag", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("inbox_tag")
    public Integer getInboxTag() {
        return inboxTag;
    }

    /**
     * Get documentFileTypeCounts
     *
     * @return documentFileTypeCounts
     */
    @NotNull
    @Valid
    @Schema(name = "document_file_type_counts", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("document_file_type_counts")
    public List<@Valid Statistics200ResponseDocumentFileTypeCountsInner>
            getDocumentFileTypeCounts() {
        return documentFileTypeCounts;
    }

    /**
     * Get characterCount
     *
     * @return characterCount
     */
    @NotNull
    @Schema(name = "character_count", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("character_count")
    public Integer getCharacterCount() {
        return characterCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Statistics200Response statistics200Response = (Statistics200Response) o;
        return Objects.equals(this.documentsTotal, statistics200Response.documentsTotal)
                && Objects.equals(this.documentsInbox, statistics200Response.documentsInbox)
                && Objects.equals(this.inboxTag, statistics200Response.inboxTag)
                && Objects.equals(
                        this.documentFileTypeCounts, statistics200Response.documentFileTypeCounts)
                && Objects.equals(this.characterCount, statistics200Response.characterCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                documentsTotal, documentsInbox, inboxTag, documentFileTypeCounts, characterCount);
    }

    @Override
    public String toString() {
        return "class Statistics200Response {\n"
                + "    documentsTotal: "
                + toIndentedString(documentsTotal)
                + "\n"
                + "    documentsInbox: "
                + toIndentedString(documentsInbox)
                + "\n"
                + "    inboxTag: "
                + toIndentedString(inboxTag)
                + "\n"
                + "    documentFileTypeCounts: "
                + toIndentedString(documentFileTypeCounts)
                + "\n"
                + "    characterCount: "
                + toIndentedString(characterCount)
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
