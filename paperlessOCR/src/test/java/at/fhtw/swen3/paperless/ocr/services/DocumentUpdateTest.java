package at.fhtw.swen3.paperless.ocr.services;

import at.fhtw.swen3.paperless.ocr.entities.DocumentEntity;
import at.fhtw.swen3.paperless.ocr.repositories.DocumentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Time;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DocumentUpdateTest {

    @Autowired
    private DocumentPostgresService documentPostgresService;

    @Autowired
    private DocumentRepository documentRepository;

    @Test
    public void testUpdate() {

        Integer id = 1;
        String docContent = "Document content";
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setId(id);
        documentEntity.setTitle("Title");
        documentEntity.setCreatedDate("Timestamp");

        //given
        this.documentRepository.save(documentEntity);

        //when
        this.documentPostgresService.updateDocumentContent(id, docContent);

        //then
        Optional<DocumentEntity> result = this.documentRepository.findById(id);

        assertTrue(result.isPresent());
        assertEquals(result.get().getId(), id);
        assertEquals(result.get().getContent(), docContent);
    }
}
