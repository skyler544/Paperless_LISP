package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonTypeName("GetSavedViews_200_response_results_inner")
public class GetSavedViews200ResponseResultsInner {
    @NotNull
    @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("id")
    private Integer id;

    @NotNull
    @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("name")
    private String name;

    @NotNull
    @Schema(name = "show_on_dashboard", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("show_on_dashboard")
    private Boolean showOnDashboard;

    @NotNull
    @Schema(name = "show_in_sidebar", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("show_in_sidebar")
    private Boolean showInSidebar;

    @NotNull
    @Schema(name = "sort_field", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("sort_field")
    private String sortField;

    @NotNull
    @Schema(name = "sort_reverse", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("sort_reverse")
    private Boolean sortReverse;

    @NotNull
    @Schema(name = "user_can_change", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("user_can_change")
    private Boolean userCanChange;
}
