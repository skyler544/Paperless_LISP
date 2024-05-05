package at.fhtw.swen3.paperless.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

import lombok.Setter;

import java.util.Objects;

/** GetTasks200ResponseInner */
@Setter
@JsonTypeName("GetTasks_200_response_inner")
@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-11-03T12:56:46.892911Z[Etc/UTC]")
public class GetTasks200ResponseInner {

    private Integer id;

    private String taskId;

    private String taskFileName;

    private String dateCreated;

    private String dateDone;

    private String type;

    private String status;

    private String result;

    private Boolean acknowledged;

    private String relatedDocument;

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
     * Get taskId
     *
     * @return taskId
     */
    @NotNull
    @Schema(name = "task_id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("task_id")
    public String getTaskId() {
        return taskId;
    }

    /**
     * Get taskFileName
     *
     * @return taskFileName
     */
    @NotNull
    @Schema(name = "task_file_name", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("task_file_name")
    public String getTaskFileName() {
        return taskFileName;
    }

    /**
     * Get dateCreated
     *
     * @return dateCreated
     */
    @NotNull
    @Schema(name = "date_created", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("date_created")
    public String getDateCreated() {
        return dateCreated;
    }

    /**
     * Get dateDone
     *
     * @return dateDone
     */
    @Schema(name = "date_done", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("date_done")
    public String getDateDone() {
        return dateDone;
    }

    /**
     * Get type
     *
     * @return type
     */
    @NotNull
    @Schema(name = "type", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Get status
     *
     * @return status
     */
    @NotNull
    @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * Get result
     *
     * @return result
     */
    @NotNull
    @Schema(name = "result", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("result")
    public String getResult() {
        return result;
    }

    /**
     * Get acknowledged
     *
     * @return acknowledged
     */
    @NotNull
    @Schema(name = "acknowledged", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("acknowledged")
    public Boolean getAcknowledged() {
        return acknowledged;
    }

    /**
     * Get relatedDocument
     *
     * @return relatedDocument
     */
    @Schema(name = "related_document", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("related_document")
    public String getRelatedDocument() {
        return relatedDocument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetTasks200ResponseInner getTasks200ResponseInner = (GetTasks200ResponseInner) o;
        return Objects.equals(this.id, getTasks200ResponseInner.id)
                && Objects.equals(this.taskId, getTasks200ResponseInner.taskId)
                && Objects.equals(this.taskFileName, getTasks200ResponseInner.taskFileName)
                && Objects.equals(this.dateCreated, getTasks200ResponseInner.dateCreated)
                && Objects.equals(this.dateDone, getTasks200ResponseInner.dateDone)
                && Objects.equals(this.type, getTasks200ResponseInner.type)
                && Objects.equals(this.status, getTasks200ResponseInner.status)
                && Objects.equals(this.result, getTasks200ResponseInner.result)
                && Objects.equals(this.acknowledged, getTasks200ResponseInner.acknowledged)
                && Objects.equals(this.relatedDocument, getTasks200ResponseInner.relatedDocument);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                taskId,
                taskFileName,
                dateCreated,
                dateDone,
                type,
                status,
                result,
                acknowledged,
                relatedDocument);
    }

    @Override
    public String toString() {
        return "class GetTasks200ResponseInner {\n"
                + "    id: "
                + toIndentedString(id)
                + "\n"
                + "    taskId: "
                + toIndentedString(taskId)
                + "\n"
                + "    taskFileName: "
                + toIndentedString(taskFileName)
                + "\n"
                + "    dateCreated: "
                + toIndentedString(dateCreated)
                + "\n"
                + "    dateDone: "
                + toIndentedString(dateDone)
                + "\n"
                + "    type: "
                + toIndentedString(type)
                + "\n"
                + "    status: "
                + toIndentedString(status)
                + "\n"
                + "    result: "
                + toIndentedString(result)
                + "\n"
                + "    acknowledged: "
                + toIndentedString(acknowledged)
                + "\n"
                + "    relatedDocument: "
                + toIndentedString(relatedDocument)
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
