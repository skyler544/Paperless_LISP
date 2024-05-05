package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

import lombok.Setter;

import java.util.Objects;

/** GetSavedViews200ResponseResultsInnerFilterRulesInner */
@Setter
@JsonTypeName("GetSavedViews_200_response_results_inner_filter_rules_inner")
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
public class GetSavedViews200ResponseResultsInnerFilterRulesInner {

    private Integer ruleType;

    private String value;

    /**
     * Get ruleType
     *
     * @return ruleType
     */
    @NotNull
    @Schema(name = "rule_type", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("rule_type")
    public Integer getRuleType() {
        return ruleType;
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
        GetSavedViews200ResponseResultsInnerFilterRulesInner
                getSavedViews200ResponseResultsInnerFilterRulesInner =
                        (GetSavedViews200ResponseResultsInnerFilterRulesInner) o;
        return Objects.equals(
                        this.ruleType,
                        getSavedViews200ResponseResultsInnerFilterRulesInner.ruleType)
                && Objects.equals(
                        this.value, getSavedViews200ResponseResultsInnerFilterRulesInner.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ruleType, value);
    }

    @Override
    public String toString() {
        return "class GetSavedViews200ResponseResultsInnerFilterRulesInner {\n"
                + "    ruleType: "
                + toIndentedString(ruleType)
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
