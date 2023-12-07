package at.fhtw.swen3.paperless.services;

import org.springframework.web.multipart.MultipartFile;
import at.fhtw.swen3.paperless.services.customDTOs.PostDocumentRequestDto;

public interface IDispatcherService {
    void handleDocument(MultipartFile file, PostDocumentRequestDto postDocRequestDto);
}
