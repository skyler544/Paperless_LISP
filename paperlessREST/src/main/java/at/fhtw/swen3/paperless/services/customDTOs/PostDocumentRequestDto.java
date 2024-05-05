package at.fhtw.swen3.paperless.services.customDTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
public class PostDocumentRequestDto {
    private String title;
    private OffsetDateTime offsetDateTime;
    private Integer documentType;
    private List<Integer> tags;
    private Integer correspondent;
}
