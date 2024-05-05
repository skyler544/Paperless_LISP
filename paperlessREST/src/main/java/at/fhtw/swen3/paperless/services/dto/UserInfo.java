package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;

import lombok.Setter;

import org.openapitools.jackson.nullable.JsonNullable;

import java.util.Arrays;
import java.util.Objects;

/** UserInfo */
@Setter
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
public class UserInfo {

    private JsonNullable<String> username = JsonNullable.undefined();

    private JsonNullable<String> password = JsonNullable.undefined();

  /**
     * Get username
     *
     * @return username
     */
    @Schema(name = "username", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("username")
    public JsonNullable<String> getUsername() {
        return username;
    }

  /**
     * Get password
     *
     * @return password
     */
    @Schema(name = "password", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("password")
    public JsonNullable<String> getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserInfo userInfo = (UserInfo) o;
        return equalsNullable(this.username, userInfo.username)
                && equalsNullable(this.password, userInfo.password);
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
        return Objects.hash(hashCodeNullable(username), hashCodeNullable(password));
    }

    private static <T> int hashCodeNullable(JsonNullable<T> a) {
        if (a == null) {
            return 1;
        }
        return a.isPresent() ? Arrays.deepHashCode(new Object[] {a.get()}) : 31;
    }

    @Override
    public String toString() {
        return "class UserInfo {\n"
                + "    username: "
                + toIndentedString(username)
                + "\n"
                + "    password: "
                + toIndentedString(password)
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
