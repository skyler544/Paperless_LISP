package at.fhtw.swen3.paperless.controller;

import at.fhtw.swen3.paperless.models.entity.DocumentEntity;
import at.fhtw.swen3.paperless.services.IDispatcherService;
import at.fhtw.swen3.paperless.services.customDTOs.GetDocumentWrapperDTO;
import at.fhtw.swen3.paperless.services.customDTOs.PostDocumentRequestDto;
import at.fhtw.swen3.paperless.services.dto.GetDocuments200Response;
import at.fhtw.swen3.paperless.services.dto.GetDocuments200ResponseResultsInner;
import at.fhtw.swen3.paperless.services.mapper.DocumentMapper;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
public class DocumentsApiController implements DocumentsApi, BaseLoggingController {

    private final Logger logger = LogManager.getLogger(ConfigApiController.class);

    private final IDispatcherService dispatcherService;

    public DocumentsApiController(IDispatcherService dispatcherService) {
        this.dispatcherService = dispatcherService;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public ResponseEntity<GetDocumentWrapperDTO> getDocuments(Integer page, Integer pageSize, String query, String ordering, List<Integer> tagsIdAll, Integer documentTypeId, Integer storagePathIdIn, Integer correspondentId, Boolean truncateContent) {
        //add service for the documents
        try {

            List<DocumentEntity> documents = this.dispatcherService.handleGetDocuments(query);

            GetDocumentWrapperDTO response = new GetDocumentWrapperDTO();
            response.setCount(documents.size());
            response.setResults(
                    documents.stream().map(doc ->
                        DocumentMapper.INSTANCE.entityToDto(doc)
                    ).toList()
            );

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<Void> uploadDocument(
            @Parameter(name = "title", description = "") @Valid @RequestParam(value = "title", required = false) String title,
            @Parameter(name = "created", description = "") @Valid @RequestParam(value = "created", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime created,
            @Parameter(name = "document_type", description = "") @Valid @RequestParam(value = "document_type", required = false) Integer documentType,
            @Parameter(name = "tags", description = "") @Valid @RequestPart(value = "tags", required = false) List<Integer> tags,
            @Parameter(name = "correspondent", description = "") @Valid @RequestParam(value = "correspondent", required = false) Integer correspondent,
            @Parameter(name = "document", description = "") @RequestPart(value = "document", required = false) List<MultipartFile> document
    ) {
        this.logReceivedRequest("UploadDocument");

        PostDocumentRequestDto postDocumentRequestDto;

        try {
            postDocumentRequestDto = extractDocumentDto(
                title, created, documentType, document);
        } catch (IOException ex) {
            this.logger.error(String.format("Error occurred while fetching the document content from the request\n%s", ex));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        this.logIncomingParams(postDocumentRequestDto.toString());

        try {
            // documentService.saveDocument(postDocumentRequestDto);
            // hardcoded, retrieve first document
            dispatcherService.handleDocument(document.get(0), postDocumentRequestDto);
        } catch (Exception ex) {
            this.logger.error(String.format("Error occurred while saving the document into the db\n%s", ex));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private PostDocumentRequestDto extractDocumentDto(
        String title, OffsetDateTime created,
        Integer documentType, List<MultipartFile> document) throws IOException {

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
