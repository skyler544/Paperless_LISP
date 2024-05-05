package at.fhtw.swen3.paperless.controller;

import at.fhtw.swen3.paperless.models.entity.DocumentEntity;
import at.fhtw.swen3.paperless.services.IDispatcherService;
import at.fhtw.swen3.paperless.services.customDTOs.GetDocumentWrapperDTO;
import at.fhtw.swen3.paperless.services.customDTOs.PostDocumentRequestDto;
import at.fhtw.swen3.paperless.services.mapper.DocumentMapper;

import io.swagger.v3.oas.annotations.Parameter;

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
    public ResponseEntity<GetDocumentWrapperDTO> getDocuments(
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

            GetDocumentWrapperDTO response = new GetDocumentWrapperDTO();
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
            @Parameter(name = "title") @Valid @RequestParam(value = "title", required = false)
                    String title,
            @Parameter(name = "created")
                    @Valid
                    @RequestParam(value = "created", required = false)
                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                    OffsetDateTime created,
            @Parameter(name = "document_type")
                    @Valid
                    @RequestParam(value = "document_type", required = false)
                    Integer documentType,
            @Parameter(name = "tags") @Valid @RequestPart(value = "tags", required = false)
                    List<Integer> tags,
            @Parameter(name = "correspondent")
                    @Valid
                    @RequestParam(value = "correspondent", required = false)
                    Integer correspondent,
            @Parameter(name = "document") @RequestPart(value = "document", required = false)
                    List<MultipartFile> document) {
        this.logReceivedRequest("UploadDocument");

        PostDocumentRequestDto postDocumentRequestDto;

        postDocumentRequestDto = extractDocumentDto(title, created, documentType, document);

        this.logIncomingParams(postDocumentRequestDto.toString());

        try {
            // documentService.saveDocument(postDocumentRequestDto);
            // hardcoded, retrieve first document
            dispatcherService.handleDocument(document.get(0), postDocumentRequestDto);
        } catch (Exception ex) {
            this.logger.error(
                    String.format("Error occurred while saving the document into the db\n%s", ex));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private PostDocumentRequestDto extractDocumentDto(
            String title,
            OffsetDateTime created,
            Integer documentType,
            List<MultipartFile> document) {

        var postDocumentRequestDto = new PostDocumentRequestDto();
        postDocumentRequestDto.setDocumentType(documentType);

        if (document != null && !document.isEmpty()) {
            for (MultipartFile singleDoc : document) {

                if (singleDoc != null && singleDoc.getOriginalFilename() != null) {

                    if (title == null || title.isEmpty()) {
                        postDocumentRequestDto.setTitle(singleDoc.getOriginalFilename());
                    } else {
                        postDocumentRequestDto.setTitle(title);
                    }

                    break;
                }
            }
        }

        if (created == null) {
            this.logger.info("Created was null.\n");
            postDocumentRequestDto.setOffsetDateTime(OffsetDateTime.now());
        } else {
            this.logger.info(String.format("Created was not Null:%s\n", created));
            postDocumentRequestDto.setOffsetDateTime(created);
        }

        return postDocumentRequestDto;
    }
}
