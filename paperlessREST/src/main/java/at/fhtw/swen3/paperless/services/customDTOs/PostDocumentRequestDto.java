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
        return "class PostDocumentRequestDto {\n"
                + "    title: "
                + toIndentedString(title)
                + "\n"
                + "    offsetDateTime: "
                + toIndentedString(offsetDateTime)
                + "\n"
                + "    documentType: "
                + toIndentedString(documentType)
                + "\n"
                + "    correspondent: "
                + toIndentedString(correspondent)
                + "\n"
                + "    tags: "
                + toIndentedString(tags)
                + "\n"
                + "}";
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
