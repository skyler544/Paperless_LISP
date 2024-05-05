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

/** GetDocumentMetadata200Response */
@Setter
@JsonTypeName("GetDocumentMetadata_200_response")
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
public class GetDocumentMetadata200Response {

    private String originalChecksum;

    private Integer originalSize;

    private String originalMimeType;

    private String mediaFilename;

    private Boolean hasArchiveVersion;

    @Valid private List<Object> originalMetadata = new ArrayList<>();

    private String archiveChecksum;

    private String archiveMediaFilename;

    private String originalFilename;

    private String lang;

    private Integer archiveSize;

    @Valid
    private List<@Valid GetDocumentMetadata200ResponseArchiveMetadataInner> archiveMetadata =
            new ArrayList<>();

    public GetDocumentMetadata200Response() {
        super();
    }

    /** Constructor with only required parameters */
    public GetDocumentMetadata200Response(
            String originalChecksum,
            Integer originalSize,
            String originalMimeType,
            String mediaFilename,
            Boolean hasArchiveVersion,
            List<Object> originalMetadata,
            String archiveChecksum,
            String archiveMediaFilename,
            String originalFilename,
            String lang,
            Integer archiveSize,
            List<@Valid GetDocumentMetadata200ResponseArchiveMetadataInner> archiveMetadata) {
        this.originalChecksum = originalChecksum;
        this.originalSize = originalSize;
        this.originalMimeType = originalMimeType;
        this.mediaFilename = mediaFilename;
        this.hasArchiveVersion = hasArchiveVersion;
        this.originalMetadata = originalMetadata;
        this.archiveChecksum = archiveChecksum;
        this.archiveMediaFilename = archiveMediaFilename;
        this.originalFilename = originalFilename;
        this.lang = lang;
        this.archiveSize = archiveSize;
        this.archiveMetadata = archiveMetadata;
    }

    /**
     * Get originalChecksum
     *
     * @return originalChecksum
     */
    @NotNull
    @Schema(name = "original_checksum", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("original_checksum")
    public String getOriginalChecksum() {
        return originalChecksum;
    }

    /**
     * Get originalSize
     *
     * @return originalSize
     */
    @NotNull
    @Schema(name = "original_size", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("original_size")
    public Integer getOriginalSize() {
        return originalSize;
    }

    /**
     * Get originalMimeType
     *
     * @return originalMimeType
     */
    @NotNull
    @Schema(name = "original_mime_type", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("original_mime_type")
    public String getOriginalMimeType() {
        return originalMimeType;
    }

    /**
     * Get mediaFilename
     *
     * @return mediaFilename
     */
    @NotNull
    @Schema(name = "media_filename", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("media_filename")
    public String getMediaFilename() {
        return mediaFilename;
    }

    /**
     * Get hasArchiveVersion
     *
     * @return hasArchiveVersion
     */
    @NotNull
    @Schema(name = "has_archive_version", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("has_archive_version")
    public Boolean getHasArchiveVersion() {
        return hasArchiveVersion;
    }

    /**
     * Get originalMetadata
     *
     * @return originalMetadata
     */
    @NotNull
    @Schema(name = "original_metadata", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("original_metadata")
    public List<Object> getOriginalMetadata() {
        return originalMetadata;
    }

    /**
     * Get archiveChecksum
     *
     * @return archiveChecksum
     */
    @NotNull
    @Schema(name = "archive_checksum", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("archive_checksum")
    public String getArchiveChecksum() {
        return archiveChecksum;
    }

    /**
     * Get archiveMediaFilename
     *
     * @return archiveMediaFilename
     */
    @NotNull
    @Schema(name = "archive_media_filename", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("archive_media_filename")
    public String getArchiveMediaFilename() {
        return archiveMediaFilename;
    }

    /**
     * Get originalFilename
     *
     * @return originalFilename
     */
    @NotNull
    @Schema(name = "original_filename", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("original_filename")
    public String getOriginalFilename() {
        return originalFilename;
    }

    /**
     * Get lang
     *
     * @return lang
     */
    @NotNull
    @Schema(name = "lang", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("lang")
    public String getLang() {
        return lang;
    }

    /**
     * Get archiveSize
     *
     * @return archiveSize
     */
    @NotNull
    @Schema(name = "archive_size", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("archive_size")
    public Integer getArchiveSize() {
        return archiveSize;
    }

    /**
     * Get archiveMetadata
     *
     * @return archiveMetadata
     */
    @NotNull
    @Valid
    @Schema(name = "archive_metadata", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("archive_metadata")
    public List<@Valid GetDocumentMetadata200ResponseArchiveMetadataInner> getArchiveMetadata() {
        return archiveMetadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetDocumentMetadata200Response getDocumentMetadata200Response =
                (GetDocumentMetadata200Response) o;
        return Objects.equals(
                        this.originalChecksum, getDocumentMetadata200Response.originalChecksum)
                && Objects.equals(this.originalSize, getDocumentMetadata200Response.originalSize)
                && Objects.equals(
                        this.originalMimeType, getDocumentMetadata200Response.originalMimeType)
                && Objects.equals(this.mediaFilename, getDocumentMetadata200Response.mediaFilename)
                && Objects.equals(
                        this.hasArchiveVersion, getDocumentMetadata200Response.hasArchiveVersion)
                && Objects.equals(
                        this.originalMetadata, getDocumentMetadata200Response.originalMetadata)
                && Objects.equals(
                        this.archiveChecksum, getDocumentMetadata200Response.archiveChecksum)
                && Objects.equals(
                        this.archiveMediaFilename,
                        getDocumentMetadata200Response.archiveMediaFilename)
                && Objects.equals(
                        this.originalFilename, getDocumentMetadata200Response.originalFilename)
                && Objects.equals(this.lang, getDocumentMetadata200Response.lang)
                && Objects.equals(this.archiveSize, getDocumentMetadata200Response.archiveSize)
                && Objects.equals(
                        this.archiveMetadata, getDocumentMetadata200Response.archiveMetadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                originalChecksum,
                originalSize,
                originalMimeType,
                mediaFilename,
                hasArchiveVersion,
                originalMetadata,
                archiveChecksum,
                archiveMediaFilename,
                originalFilename,
                lang,
                archiveSize,
                archiveMetadata);
    }

    @Override
    public String toString() {
        return "class GetDocumentMetadata200Response {\n"
                + "    originalChecksum: "
                + toIndentedString(originalChecksum)
                + "\n"
                + "    originalSize: "
                + toIndentedString(originalSize)
                + "\n"
                + "    originalMimeType: "
                + toIndentedString(originalMimeType)
                + "\n"
                + "    mediaFilename: "
                + toIndentedString(mediaFilename)
                + "\n"
                + "    hasArchiveVersion: "
                + toIndentedString(hasArchiveVersion)
                + "\n"
                + "    originalMetadata: "
                + toIndentedString(originalMetadata)
                + "\n"
                + "    archiveChecksum: "
                + toIndentedString(archiveChecksum)
                + "\n"
                + "    archiveMediaFilename: "
                + toIndentedString(archiveMediaFilename)
                + "\n"
                + "    originalFilename: "
                + toIndentedString(originalFilename)
                + "\n"
                + "    lang: "
                + toIndentedString(lang)
                + "\n"
                + "    archiveSize: "
                + toIndentedString(archiveSize)
                + "\n"
                + "    archiveMetadata: "
                + toIndentedString(archiveMetadata)
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
