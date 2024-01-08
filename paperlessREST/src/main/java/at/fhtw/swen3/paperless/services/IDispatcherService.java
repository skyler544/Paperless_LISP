package at.fhtw.swen3.paperless.services;

import at.fhtw.swen3.paperless.models.entity.DocumentEntity;
import at.fhtw.swen3.paperless.services.customDTOs.PostDocumentRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IDispatcherService {
    void handleDocument(MultipartFile file, PostDocumentRequestDto postDocRequestDto) throws JsonProcessingException;

    List<DocumentEntity> handleGetDocuments(String query) throws IOException;
}
