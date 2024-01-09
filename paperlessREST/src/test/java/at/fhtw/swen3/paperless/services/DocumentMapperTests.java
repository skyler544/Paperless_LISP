package at.fhtw.swen3.paperless.services;

import at.fhtw.swen3.paperless.models.entity.DocumentEntity;
import at.fhtw.swen3.paperless.services.dto.GetDocument200Response;
import at.fhtw.swen3.paperless.services.mapper.DocumentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentMapperTests {

    @Test
    void DocumentEntityIsMappedToDocumentDto() {
        DocumentEntity documentEntity = DocumentEntity.builder()
                .id(1)
                .title("Test title")
                .content("This is a test")
                .build();


        GetDocument200Response result = DocumentMapper.INSTANCE.entityToDto(documentEntity);

        assertEquals(documentEntity.getId(),result.getId());
        assertEquals(documentEntity.getTitle(), result.getTitle());
        assertEquals(documentEntity.getContent(), result.getContent());

    }

}
