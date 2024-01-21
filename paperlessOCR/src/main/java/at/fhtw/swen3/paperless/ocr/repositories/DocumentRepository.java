package at.fhtw.swen3.paperless.ocr.repositories;

import at.fhtw.swen3.paperless.ocr.entities.DocumentEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DocumentRepository extends JpaRepository<DocumentEntity, Integer> {

    //custom method to perform update on document
    @Transactional //transactional is needed for hibernate to work
    @Modifying //overwrite default JPA behaviour
    @Query("update document as d set d.content = :content where d.id = :id")
    void updateDocumentContentById(@Param("content") String content, @Param("id") Integer id);

}
