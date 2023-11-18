package at.fhtw.swen3.paperless.services;

import at.fhtw.swen3.paperless.models.entity.DocumentEntity;
import at.fhtw.swen3.paperless.services.repositories.DocumentRepository;
import at.fhtw.swen3.paperless.services.dto.PostDocumentRequestDto;
import at.fhtw.swen3.paperless.services.mapper.PostDocumentMapper;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public DocumentEntity saveDocument(PostDocumentRequestDto postDocumentRequestDto) {
        var result = PostDocumentMapper.INSTANCE.dtoToEntity(postDocumentRequestDto);
        documentRepository.save(result);
        return result;
    }
}
