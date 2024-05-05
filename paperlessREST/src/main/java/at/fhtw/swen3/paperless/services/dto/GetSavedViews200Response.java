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

/** GetSavedViews200Response */
@Setter
@JsonTypeName("GetSavedViews_200_response")
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
public class GetSavedViews200Response {

    private Integer count;

    private Integer next;

    private Integer previous;

    @Valid private List<Integer> all = new ArrayList<>();

    @Valid private List<@Valid GetSavedViews200ResponseResultsInner> results = new ArrayList<>();

    public GetSavedViews200Response() {
        super();
    }

    /**
     * Get count
     *
     * @return count
     */
    @NotNull
    @Schema(name = "count", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    /**
     * Get next
     *
     * @return next
     */
    @NotNull
    @Schema(name = "next", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("next")
    public Integer getNext() {
        return next;
    }

    /**
     * Get previous
     *
     * @return previous
     */
    @NotNull
    @Schema(name = "previous", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("previous")
    public Integer getPrevious() {
        return previous;
    }

    /**
     * Get all
     *
     * @return all
     */
    @NotNull
    @Schema(name = "all", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("all")
    public List<Integer> getAll() {
        return all;
    }

    /**
     * Get results
     *
     * @return results
     */
    @NotNull
    @Valid
    @Schema(name = "results", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("results")
    public List<@Valid GetSavedViews200ResponseResultsInner> getResults() {
        return results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetSavedViews200Response getSavedViews200Response = (GetSavedViews200Response) o;
        return Objects.equals(this.count, getSavedViews200Response.count)
                && Objects.equals(this.next, getSavedViews200Response.next)
                && Objects.equals(this.previous, getSavedViews200Response.previous)
                && Objects.equals(this.all, getSavedViews200Response.all)
                && Objects.equals(this.results, getSavedViews200Response.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, next, previous, all, results);
    }

    @Override
    public String toString() {
        return "class GetSavedViews200Response {\n"
                + "    count: "
                + toIndentedString(count)
                + "\n"
                + "    next: "
                + toIndentedString(next)
                + "\n"
                + "    previous: "
                + toIndentedString(previous)
                + "\n"
                + "    all: "
                + toIndentedString(all)
                + "\n"
                + "    results: "
                + toIndentedString(results)
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
