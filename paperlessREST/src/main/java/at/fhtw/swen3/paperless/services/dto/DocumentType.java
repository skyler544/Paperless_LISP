package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;

import lombok.Setter;

import org.openapitools.jackson.nullable.JsonNullable;

import java.util.Arrays;
import java.util.Objects;

/** DocumentType */
@Setter
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
public class DocumentType {

    private Long id;

    private JsonNullable<String> slug = JsonNullable.undefined();

    private JsonNullable<String> name = JsonNullable.undefined();

    private JsonNullable<String> match = JsonNullable.undefined();

    private Long matchingAlgorithm;

    private Boolean isInsensitive;

    private Long documentCount;

    /**
     * Get id
     *
     * @return id
     */
    @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    /**
     * Get slug
     *
     * @return slug
     */
    @Schema(name = "slug", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("slug")
    public JsonNullable<String> getSlug() {
        return slug;
    }

    /**
     * Get name
     *
     * @return name
     */
    @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("name")
    public JsonNullable<String> getName() {
        return name;
    }

    /**
     * Get match
     *
     * @return match
     */
    @Schema(name = "match", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("match")
    public JsonNullable<String> getMatch() {
        return match;
    }

    /**
     * Get matchingAlgorithm
     *
     * @return matchingAlgorithm
     */
    @Schema(name = "matching_algorithm", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("matching_algorithm")
    public Long getMatchingAlgorithm() {
        return matchingAlgorithm;
    }

    /**
     * Get isInsensitive
     *
     * @return isInsensitive
     */
    @Schema(name = "is_insensitive", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("is_insensitive")
    public Boolean getIsInsensitive() {
        return isInsensitive;
    }

    /**
     * Get documentCount
     *
     * @return documentCount
     */
    @Schema(name = "document_count", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("document_count")
    public Long getDocumentCount() {
        return documentCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DocumentType documentType = (DocumentType) o;
        return Objects.equals(this.id, documentType.id)
                && equalsNullable(this.slug, documentType.slug)
                && equalsNullable(this.name, documentType.name)
                && equalsNullable(this.match, documentType.match)
                && Objects.equals(this.matchingAlgorithm, documentType.matchingAlgorithm)
                && Objects.equals(this.isInsensitive, documentType.isInsensitive)
                && Objects.equals(this.documentCount, documentType.documentCount);
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
                hashCodeNullable(slug),
                hashCodeNullable(name),
                hashCodeNullable(match),
                matchingAlgorithm,
                isInsensitive,
                documentCount);
    }

    private static <T> int hashCodeNullable(JsonNullable<T> a) {
        if (a == null) {
            return 1;
        }
        return a.isPresent() ? Arrays.deepHashCode(new Object[] {a.get()}) : 31;
    }

    @Override
    public String toString() {
        return "class DocumentType {\n"
                + "    id: "
                + toIndentedString(id)
                + "\n"
                + "    slug: "
                + toIndentedString(slug)
                + "\n"
                + "    name: "
                + toIndentedString(name)
                + "\n"
                + "    match: "
                + toIndentedString(match)
                + "\n"
                + "    matchingAlgorithm: "
                + toIndentedString(matchingAlgorithm)
                + "\n"
                + "    isInsensitive: "
                + toIndentedString(isInsensitive)
                + "\n"
                + "    documentCount: "
                + toIndentedString(documentCount)
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
