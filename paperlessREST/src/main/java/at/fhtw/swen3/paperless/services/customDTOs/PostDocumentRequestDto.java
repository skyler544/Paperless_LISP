package at.fhtw.swen3.paperless.services.customDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDocumentRequestDto {
    private String title;
    private OffsetDateTime offsetDateTime;
    private Integer documentType;
    private List<Integer> tags;
    private Integer correspondent;
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PostDocumentRequestDto {\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    offsetDateTime: ").append(toIndentedString(offsetDateTime)).append("\n");
        sb.append("    documentType: ").append(toIndentedString(documentType)).append("\n");
        sb.append("    correspondent: ").append(toIndentedString(correspondent)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
