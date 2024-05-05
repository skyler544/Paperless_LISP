package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

import lombok.Setter;

import java.util.Objects;

/** GetDocumentMetadata200ResponseArchiveMetadataInner */
@Setter
@JsonTypeName("GetDocumentMetadata_200_response_archive_metadata_inner")
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
public class GetDocumentMetadata200ResponseArchiveMetadataInner {

    private String namespace;

    private String prefix;

    private String key;

    private String value;

    /**
     * Get namespace
     *
     * @return namespace
     */
    @NotNull
    @Schema(name = "namespace", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * Get prefix
     *
     * @return prefix
     */
    @NotNull
    @Schema(name = "prefix", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("prefix")
    public String getPrefix() {
        return prefix;
    }

    /**
     * Get key
     *
     * @return key
     */
    @NotNull
    @Schema(name = "key", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * Get value
     *
     * @return value
     */
    @NotNull
    @Schema(name = "value", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetDocumentMetadata200ResponseArchiveMetadataInner
                getDocumentMetadata200ResponseArchiveMetadataInner =
                        (GetDocumentMetadata200ResponseArchiveMetadataInner) o;
        return Objects.equals(
                        this.namespace,
                        getDocumentMetadata200ResponseArchiveMetadataInner.namespace)
                && Objects.equals(
                        this.prefix, getDocumentMetadata200ResponseArchiveMetadataInner.prefix)
                && Objects.equals(this.key, getDocumentMetadata200ResponseArchiveMetadataInner.key)
                && Objects.equals(
                        this.value, getDocumentMetadata200ResponseArchiveMetadataInner.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namespace, prefix, key, value);
    }

    @Override
    public String toString() {
        return "class GetDocumentMetadata200ResponseArchiveMetadataInner {\n"
                + "    namespace: "
                + toIndentedString(namespace)
                + "\n"
                + "    prefix: "
                + toIndentedString(prefix)
                + "\n"
                + "    key: "
                + toIndentedString(key)
                + "\n"
                + "    value: "
                + toIndentedString(value)
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
