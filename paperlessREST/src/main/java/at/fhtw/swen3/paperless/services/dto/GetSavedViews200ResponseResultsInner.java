package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonTypeName("GetSavedViews_200_response_results_inner")
public class GetSavedViews200ResponseResultsInner {
    @NotNull
    @JsonProperty("id")
    private Integer id;

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("show_on_dashboard")
    private Boolean showOnDashboard;

    @NotNull
    @JsonProperty("show_in_sidebar")
    private Boolean showInSidebar;

    @NotNull
    @JsonProperty("sort_field")
    private String sortField;

    @NotNull
    @JsonProperty("sort_reverse")
    private Boolean sortReverse;

    @NotNull
    @JsonProperty("user_can_change")
    private Boolean userCanChange;
}
