package at.fhtw.swen3.paperless.services;

import at.fhtw.swen3.paperless.services.customDTOs.PostDocumentRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.multipart.MultipartFile;

public interface IDispatcherService {
    void handleDocument(MultipartFile file, PostDocumentRequestDto postDocRequestDto) throws JsonProcessingException;
}
