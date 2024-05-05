package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

import lombok.Setter;

import java.util.Objects;

/** Statistics200ResponseDocumentFileTypeCountsInner */
@Setter
@JsonTypeName("Statistics_200_response_document_file_type_counts_inner")
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-11-03T12:56:46.892911Z[Etc/UTC]")
public class Statistics200ResponseDocumentFileTypeCountsInner {

    private String mimeType;

    private Integer mimeTypeCount;

    /**
     * Get mimeType
     *
     * @return mimeType
     */
    @NotNull
    @Schema(name = "mime_type", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("mime_type")
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Get mimeTypeCount
     *
     * @return mimeTypeCount
     */
    @NotNull
    @Schema(name = "mime_type_count", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("mime_type_count")
    public Integer getMimeTypeCount() {
        return mimeTypeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Statistics200ResponseDocumentFileTypeCountsInner
                statistics200ResponseDocumentFileTypeCountsInner =
                        (Statistics200ResponseDocumentFileTypeCountsInner) o;
        return Objects.equals(
                        this.mimeType, statistics200ResponseDocumentFileTypeCountsInner.mimeType)
                && Objects.equals(
                        this.mimeTypeCount,
                        statistics200ResponseDocumentFileTypeCountsInner.mimeTypeCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mimeType, mimeTypeCount);
    }

    @Override
    public String toString() {
        return "class Statistics200ResponseDocumentFileTypeCountsInner {\n"
                + "    mimeType: "
                + toIndentedString(mimeType)
                + "\n"
                + "    mimeTypeCount: "
                + toIndentedString(mimeTypeCount)
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
