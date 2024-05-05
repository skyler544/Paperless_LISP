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

/** GetSavedViews200ResponseResultsInner */
@Setter
@JsonTypeName("GetSavedViews_200_response_results_inner")
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
public class GetSavedViews200ResponseResultsInner {

    private Integer id;

    private String name;

    private Boolean showOnDashboard;

    private Boolean showInSidebar;

    private String sortField;

    private Boolean sortReverse;

    @Valid
    private List<@Valid GetSavedViews200ResponseResultsInnerFilterRulesInner> filterRules =
            new ArrayList<>();

    private GetSavedViews200ResponseResultsInnerOwner owner;

    private Boolean userCanChange;

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
     * Get name
     *
     * @return name
     */
    @NotNull
    @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Get showOnDashboard
     *
     * @return showOnDashboard
     */
    @NotNull
    @Schema(name = "show_on_dashboard", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("show_on_dashboard")
    public Boolean getShowOnDashboard() {
        return showOnDashboard;
    }

    /**
     * Get showInSidebar
     *
     * @return showInSidebar
     */
    @NotNull
    @Schema(name = "show_in_sidebar", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("show_in_sidebar")
    public Boolean getShowInSidebar() {
        return showInSidebar;
    }

    /**
     * Get sortField
     *
     * @return sortField
     */
    @NotNull
    @Schema(name = "sort_field", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("sort_field")
    public String getSortField() {
        return sortField;
    }

    /**
     * Get sortReverse
     *
     * @return sortReverse
     */
    @NotNull
    @Schema(name = "sort_reverse", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("sort_reverse")
    public Boolean getSortReverse() {
        return sortReverse;
    }

    /**
     * Get filterRules
     *
     * @return filterRules
     */
    @NotNull
    @Valid
    @Schema(name = "filter_rules", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("filter_rules")
    public List<@Valid GetSavedViews200ResponseResultsInnerFilterRulesInner> getFilterRules() {
        return filterRules;
    }

    /**
     * Get owner
     *
     * @return owner
     */
    @NotNull
    @Valid
    @Schema(name = "owner", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("owner")
    public GetSavedViews200ResponseResultsInnerOwner getOwner() {
        return owner;
    }

    /**
     * Get userCanChange
     *
     * @return userCanChange
     */
    @NotNull
    @Schema(name = "user_can_change", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("user_can_change")
    public Boolean getUserCanChange() {
        return userCanChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetSavedViews200ResponseResultsInner getSavedViews200ResponseResultsInner =
                (GetSavedViews200ResponseResultsInner) o;
        return Objects.equals(this.id, getSavedViews200ResponseResultsInner.id)
                && Objects.equals(this.name, getSavedViews200ResponseResultsInner.name)
                && Objects.equals(
                        this.showOnDashboard, getSavedViews200ResponseResultsInner.showOnDashboard)
                && Objects.equals(
                        this.showInSidebar, getSavedViews200ResponseResultsInner.showInSidebar)
                && Objects.equals(this.sortField, getSavedViews200ResponseResultsInner.sortField)
                && Objects.equals(
                        this.sortReverse, getSavedViews200ResponseResultsInner.sortReverse)
                && Objects.equals(
                        this.filterRules, getSavedViews200ResponseResultsInner.filterRules)
                && Objects.equals(this.owner, getSavedViews200ResponseResultsInner.owner)
                && Objects.equals(
                        this.userCanChange, getSavedViews200ResponseResultsInner.userCanChange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                name,
                showOnDashboard,
                showInSidebar,
                sortField,
                sortReverse,
                filterRules,
                owner,
                userCanChange);
    }

    @Override
    public String toString() {
        return "class GetSavedViews200ResponseResultsInner {\n"
                + "    id: "
                + toIndentedString(id)
                + "\n"
                + "    name: "
                + toIndentedString(name)
                + "\n"
                + "    showOnDashboard: "
                + toIndentedString(showOnDashboard)
                + "\n"
                + "    showInSidebar: "
                + toIndentedString(showInSidebar)
                + "\n"
                + "    sortField: "
                + toIndentedString(sortField)
                + "\n"
                + "    sortReverse: "
                + toIndentedString(sortReverse)
                + "\n"
                + "    filterRules: "
                + toIndentedString(filterRules)
                + "\n"
                + "    owner: "
                + toIndentedString(owner)
                + "\n"
                + "    userCanChange: "
                + toIndentedString(userCanChange)
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
