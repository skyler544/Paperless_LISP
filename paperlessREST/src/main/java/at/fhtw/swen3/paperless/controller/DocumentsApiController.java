package at.fhtw.swen3.paperless.controller;

import at.fhtw.swen3.paperless.services.DocumentService;
import at.fhtw.swen3.paperless.services.customDTOs.PostDocumentRequestDto;
import io.swagger.v3.oas.annotations.Parameter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.*;
import java.time.OffsetDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import jakarta.validation.Valid;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
public class DocumentsApiController implements DocumentsApi, BaseLoggingController {

    private final Logger logger = LogManager.getLogger(ConfigApiController.class);

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    private final NativeWebRequest request;

    private final DocumentService documentService;

    @Autowired
    public DocumentsApiController(NativeWebRequest request, DocumentService documentService) {
        this.documentService = documentService;
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
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

        PostDocumentRequestDto postDocumentRequestDto = new PostDocumentRequestDto();
        postDocumentRequestDto.setDocumentType(documentType);

        this.logReceivedRequest("UploadDocument");

        try {

            if (document != null && !document.isEmpty()) {

                //TODO check with prof if we have to parse multiple docs
                for (MultipartFile singleDoc : document) {

                    if (singleDoc != null && singleDoc.getOriginalFilename() != null) {

                        byte[] docBites = singleDoc.getBytes();

                        String encodedFileContent = Base64.getEncoder().encodeToString(docBites);

                        postDocumentRequestDto.setDocumentContentBase64(encodedFileContent);

                        System.out.println("Base64 length: " + encodedFileContent.length());

                        if (title == null || title.isEmpty()) {
                            postDocumentRequestDto.setTitle(singleDoc.getOriginalFilename());
                        } else {
                            postDocumentRequestDto.setTitle(title);
                        }

                        break;

                    }

                }
            }

        } catch (IOException ex) {
            this.logger.error(String.format("Error occurred while fetching the document content from the request\n%s", ex));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (created == null) {
            postDocumentRequestDto.setOffsetDateTime(OffsetDateTime.now());
        }

        this.logIncomingParams(postDocumentRequestDto.toString());

        try {
            documentService.saveDocument(postDocumentRequestDto);
        } catch (Exception ex) {
            this.logger.error(String.format("Error occurred while saving the document into the db\n%s", ex));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
