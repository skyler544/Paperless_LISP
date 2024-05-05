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

/** GetSavedViews200ResponseResultsInnerOwner */
@Setter
@JsonTypeName("GetSavedViews_200_response_results_inner_owner")
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
public class GetSavedViews200ResponseResultsInnerOwner {

    private Integer id;

    private String password;

    private String lastLogin;

    private Boolean isSuperuser;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private Boolean isStaff;

    private Boolean isActive;

    private String dateJoined;

    @Valid private List<Object> groups = new ArrayList<>();

    @Valid private List<Integer> userPermissions = new ArrayList<>();

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
     * Get password
     *
     * @return password
     */
    @NotNull
    @Schema(name = "password", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * Get lastLogin
     *
     * @return lastLogin
     */
    @NotNull
    @Schema(name = "last_login", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("last_login")
    public String getLastLogin() {
        return lastLogin;
    }

    /**
     * Get isSuperuser
     *
     * @return isSuperuser
     */
    @NotNull
    @Schema(name = "is_superuser", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("is_superuser")
    public Boolean getIsSuperuser() {
        return isSuperuser;
    }

    /**
     * Get username
     *
     * @return username
     */
    @NotNull
    @Schema(name = "username", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * Get firstName
     *
     * @return firstName
     */
    @NotNull
    @Schema(name = "first_name", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get lastName
     *
     * @return lastName
     */
    @NotNull
    @Schema(name = "last_name", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * Get email
     *
     * @return email
     */
    @NotNull
    @Schema(name = "email", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * Get isStaff
     *
     * @return isStaff
     */
    @NotNull
    @Schema(name = "is_staff", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("is_staff")
    public Boolean getIsStaff() {
        return isStaff;
    }

    /**
     * Get isActive
     *
     * @return isActive
     */
    @NotNull
    @Schema(name = "is_active", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("is_active")
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * Get dateJoined
     *
     * @return dateJoined
     */
    @NotNull
    @Schema(name = "date_joined", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("date_joined")
    public String getDateJoined() {
        return dateJoined;
    }

    /**
     * Get groups
     *
     * @return groups
     */
    @NotNull
    @Schema(name = "groups", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("groups")
    public List<Object> getGroups() {
        return groups;
    }

    /**
     * Get userPermissions
     *
     * @return userPermissions
     */
    @NotNull
    @Schema(name = "user_permissions", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("user_permissions")
    public List<Integer> getUserPermissions() {
        return userPermissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetSavedViews200ResponseResultsInnerOwner getSavedViews200ResponseResultsInnerOwner =
                (GetSavedViews200ResponseResultsInnerOwner) o;
        return Objects.equals(this.id, getSavedViews200ResponseResultsInnerOwner.id)
                && Objects.equals(this.password, getSavedViews200ResponseResultsInnerOwner.password)
                && Objects.equals(
                        this.lastLogin, getSavedViews200ResponseResultsInnerOwner.lastLogin)
                && Objects.equals(
                        this.isSuperuser, getSavedViews200ResponseResultsInnerOwner.isSuperuser)
                && Objects.equals(this.username, getSavedViews200ResponseResultsInnerOwner.username)
                && Objects.equals(
                        this.firstName, getSavedViews200ResponseResultsInnerOwner.firstName)
                && Objects.equals(this.lastName, getSavedViews200ResponseResultsInnerOwner.lastName)
                && Objects.equals(this.email, getSavedViews200ResponseResultsInnerOwner.email)
                && Objects.equals(this.isStaff, getSavedViews200ResponseResultsInnerOwner.isStaff)
                && Objects.equals(this.isActive, getSavedViews200ResponseResultsInnerOwner.isActive)
                && Objects.equals(
                        this.dateJoined, getSavedViews200ResponseResultsInnerOwner.dateJoined)
                && Objects.equals(this.groups, getSavedViews200ResponseResultsInnerOwner.groups)
                && Objects.equals(
                        this.userPermissions,
                        getSavedViews200ResponseResultsInnerOwner.userPermissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                password,
                lastLogin,
                isSuperuser,
                username,
                firstName,
                lastName,
                email,
                isStaff,
                isActive,
                dateJoined,
                groups,
                userPermissions);
    }

    @Override
    public String toString() {
        return "class GetSavedViews200ResponseResultsInnerOwner {\n"
                + "    id: "
                + toIndentedString(id)
                + "\n"
                + "    password: "
                + toIndentedString(password)
                + "\n"
                + "    lastLogin: "
                + toIndentedString(lastLogin)
                + "\n"
                + "    isSuperuser: "
                + toIndentedString(isSuperuser)
                + "\n"
                + "    username: "
                + toIndentedString(username)
                + "\n"
                + "    firstName: "
                + toIndentedString(firstName)
                + "\n"
                + "    lastName: "
                + toIndentedString(lastName)
                + "\n"
                + "    email: "
                + toIndentedString(email)
                + "\n"
                + "    isStaff: "
                + toIndentedString(isStaff)
                + "\n"
                + "    isActive: "
                + toIndentedString(isActive)
                + "\n"
                + "    dateJoined: "
                + toIndentedString(dateJoined)
                + "\n"
                + "    groups: "
                + toIndentedString(groups)
                + "\n"
                + "    userPermissions: "
                + toIndentedString(userPermissions)
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
