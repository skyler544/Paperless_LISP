package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import lombok.Setter;

import java.util.Objects;

/** GetDocument200ResponsePermissions */
@Setter
@JsonTypeName("GetDocument_200_response_permissions")
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
public class GetDocument200ResponsePermissions {

    private GetDocument200ResponsePermissionsView view;

    private GetDocument200ResponsePermissionsView change;

    /**
     * Get view
     *
     * @return view
     */
    @NotNull
    @Valid
    @Schema(name = "view", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("view")
    public GetDocument200ResponsePermissionsView getView() {
        return view;
    }

    /**
     * Get change
     *
     * @return change
     */
    @NotNull
    @Valid
    @Schema(name = "change", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("change")
    public GetDocument200ResponsePermissionsView getChange() {
        return change;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetDocument200ResponsePermissions getDocument200ResponsePermissions =
                (GetDocument200ResponsePermissions) o;
        return Objects.equals(this.view, getDocument200ResponsePermissions.view)
                && Objects.equals(this.change, getDocument200ResponsePermissions.change);
    }

    @Override
    public int hashCode() {
        return Objects.hash(view, change);
    }

    @Override
    public String toString() {
        return "class GetDocument200ResponsePermissions {\n"
                + "    view: "
                + toIndentedString(view)
                + "\n"
                + "    change: "
                + toIndentedString(change)
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
