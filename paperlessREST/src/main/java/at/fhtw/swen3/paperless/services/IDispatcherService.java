package at.fhtw.swen3.paperless.services;

import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import at.fhtw.swen3.paperless.services.customDTOs.PostDocumentRequestDto;

public interface IDispatcherService {
    void handleDocument(MultipartFile file, PostDocumentRequestDto postDocRequestDto) throws JsonProcessingException;
}
