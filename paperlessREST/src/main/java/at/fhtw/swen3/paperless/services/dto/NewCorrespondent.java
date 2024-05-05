package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import lombok.Setter;

import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Objects;

/** NewCorrespondent */
@Setter
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
public class NewCorrespondent {

    private JsonNullable<String> name = JsonNullable.undefined();

    private JsonNullable<String> match = JsonNullable.undefined();

    private Long matchingAlgorithm;

    private Boolean isInsensitive;

    private Long documentCount;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime lastCorrespondence;

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

    /**
     * Get lastCorrespondence
     *
     * @return lastCorrespondence
     */
    @Valid
    @Schema(name = "last_correspondence", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("last_correspondence")
    public OffsetDateTime getLastCorrespondence() {
        return lastCorrespondence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NewCorrespondent newCorrespondent = (NewCorrespondent) o;
        return equalsNullable(this.name, newCorrespondent.name)
                && equalsNullable(this.match, newCorrespondent.match)
                && Objects.equals(this.matchingAlgorithm, newCorrespondent.matchingAlgorithm)
                && Objects.equals(this.isInsensitive, newCorrespondent.isInsensitive)
                && Objects.equals(this.documentCount, newCorrespondent.documentCount)
                && Objects.equals(this.lastCorrespondence, newCorrespondent.lastCorrespondence);
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
                hashCodeNullable(name),
                hashCodeNullable(match),
                matchingAlgorithm,
                isInsensitive,
                documentCount,
                lastCorrespondence);
    }

    private static <T> int hashCodeNullable(JsonNullable<T> a) {
        if (a == null) {
            return 1;
        }
        return a.isPresent() ? Arrays.deepHashCode(new Object[] {a.get()}) : 31;
    }

    @Override
    public String toString() {
        return "class NewCorrespondent {\n"
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
                + "    lastCorrespondence: "
                + toIndentedString(lastCorrespondence)
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
