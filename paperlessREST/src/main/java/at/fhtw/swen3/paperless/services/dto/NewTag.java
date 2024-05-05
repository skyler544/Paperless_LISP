package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;

import lombok.Setter;

import org.openapitools.jackson.nullable.JsonNullable;

import java.util.Arrays;
import java.util.Objects;

/** NewTag */
@Setter
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
public class NewTag {

    private JsonNullable<String> name = JsonNullable.undefined();

    private JsonNullable<String> color = JsonNullable.undefined();

    private JsonNullable<String> match = JsonNullable.undefined();

    private Long matchingAlgorithm;

    private Boolean isInsensitive;

    private Boolean isInboxTag;

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
     * Get color
     *
     * @return color
     */
    @Schema(name = "color", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("color")
    public JsonNullable<String> getColor() {
        return color;
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
     * Get isInboxTag
     *
     * @return isInboxTag
     */
    @Schema(name = "is_inbox_tag", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("is_inbox_tag")
    public Boolean getIsInboxTag() {
        return isInboxTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NewTag newTag = (NewTag) o;
        return equalsNullable(this.name, newTag.name)
                && equalsNullable(this.color, newTag.color)
                && equalsNullable(this.match, newTag.match)
                && Objects.equals(this.matchingAlgorithm, newTag.matchingAlgorithm)
                && Objects.equals(this.isInsensitive, newTag.isInsensitive)
                && Objects.equals(this.isInboxTag, newTag.isInboxTag);
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
                hashCodeNullable(color),
                hashCodeNullable(match),
                matchingAlgorithm,
                isInsensitive,
                isInboxTag);
    }

    private static <T> int hashCodeNullable(JsonNullable<T> a) {
        if (a == null) {
            return 1;
        }
        return a.isPresent() ? Arrays.deepHashCode(new Object[] {a.get()}) : 31;
    }

    @Override
    public String toString() {
        return "class NewTag {\n"
                + "    name: "
                + toIndentedString(name)
                + "\n"
                + "    color: "
                + toIndentedString(color)
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
                + "    isInboxTag: "
                + toIndentedString(isInboxTag)
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
