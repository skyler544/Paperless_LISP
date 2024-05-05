package at.fhtw.swen3.paperless.controller;

import at.fhtw.swen3.paperless.models.entity.DocumentEntity;
import at.fhtw.swen3.paperless.services.IDispatcherService;
import at.fhtw.swen3.paperless.services.dto.Document;
import at.fhtw.swen3.paperless.services.dto.GetDocuments200Response;
import at.fhtw.swen3.paperless.services.mapper.DocumentMapper;

import jakarta.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;

@Controller
public class DocumentsApiController implements DocumentsApi, BaseLoggingController {

    private final Logger logger = LogManager.getLogger(DocumentsApiController.class);

    private final IDispatcherService dispatcherService;

    public DocumentsApiController(IDispatcherService dispatcherService) {
        this.dispatcherService = dispatcherService;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public ResponseEntity<GetDocuments200Response> getDocuments(
            Integer page,
            Integer pageSize,
            String query,
            String ordering,
            List<Integer> tagsIdAll,
            Integer documentTypeId,
            Integer storagePathIdIn,
            Integer correspondentId,
            Boolean truncateContent) {

        try {
            List<DocumentEntity> documents = this.dispatcherService.handleGetDocuments(query);

            GetDocuments200Response response = new GetDocuments200Response();
            response.setCount(documents.size());
            response.setResults(
                    documents.stream().map(DocumentMapper.INSTANCE::entityToDto).toList());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Void> uploadDocument(
            @Valid @RequestParam(value = "title", required = false) String title,
            @Valid
                    @RequestParam(value = "created", required = false)
                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                    OffsetDateTime created,
            @Valid @RequestParam(value = "document_type", required = false) Integer documentType,
            @Valid @RequestPart(value = "tags", required = false) List<Integer> tags,
            @Valid @RequestParam(value = "correspondent", required = false) Integer correspondent,
            @RequestPart(value = "document", required = false) List<MultipartFile> document) {

        this.logReceivedRequest("UploadDocument");
        // hardcoded, retrieve first document
        var firstDocument = document.get(0);

        var documentDTO = getDocumentDTO(firstDocument);

        this.logIncomingParams(documentDTO.toString());

        try {
            dispatcherService.handleDocument(firstDocument, documentDTO);
        } catch (Exception e) {
            this.logger.error(
                    String.format("Error occurred while saving the document into the db\n%s", e));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private Document getDocumentDTO(MultipartFile firstDocument) {
        var documentDTO = new Document();
        documentDTO.setTitle(firstDocument.getOriginalFilename());
        documentDTO.setDocumentType(firstDocument.getContentType());
        documentDTO.setCreatedDate(OffsetDateTime.now().toString());
        return documentDTO;
    }
}
