package at.fhtw.swen3.paperless.controller;

import at.fhtw.swen3.paperless.services.dto.*;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

import jakarta.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
import java.util.List;

@Validated
@Controller
public interface DocumentsApi {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/documents/{id}/",
            produces = {"application/json"})
    default ResponseEntity<GetDocument200Response> getDocument(
            @Parameter(name = "id", required = true, in = ParameterIn.PATH) @PathVariable("id")
                    Integer id,
            @Parameter(name = "page", in = ParameterIn.QUERY)
                    @Valid
                    @RequestParam(value = "page", required = false)
                    Integer page,
            @Parameter(name = "full_perms", in = ParameterIn.QUERY)
                    @Valid
                    @RequestParam(value = "full_perms", required = false)
                    Boolean fullPerms) {
        return new ResponseEntity<>(new GetDocument200Response(), HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/documents/",
            produces = {"application/json"})
    default ResponseEntity<GetDocuments200Response> getDocuments(
            @Parameter(name = "Page", in = ParameterIn.QUERY)
                    @Valid
                    @RequestParam(value = "Page", required = false)
                    Integer page,
            @Parameter(name = "page_size", in = ParameterIn.QUERY)
                    @Valid
                    @RequestParam(value = "page_size", required = false)
                    Integer pageSize,
            @Parameter(name = "query", in = ParameterIn.QUERY)
                    @Valid
                    @RequestParam(value = "query", required = false)
                    String query,
            @Parameter(name = "ordering", in = ParameterIn.QUERY)
                    @Valid
                    @RequestParam(value = "ordering", required = false)
                    String ordering,
            @Parameter(name = "tags__id__all", in = ParameterIn.QUERY)
                    @Valid
                    @RequestParam(value = "tags__id__all", required = false)
                    List<Integer> tagsIdAll,
            @Parameter(name = "document_type__id", in = ParameterIn.QUERY)
                    @Valid
                    @RequestParam(value = "document_type__id", required = false)
                    Integer documentTypeId,
            @Parameter(name = "storage_path__id__in", in = ParameterIn.QUERY)
                    @Valid
                    @RequestParam(value = "storage_path__id__in", required = false)
                    Integer storagePathIdIn,
            @Parameter(name = "correspondent__id", in = ParameterIn.QUERY)
                    @Valid
                    @RequestParam(value = "correspondent__id", required = false)
                    Integer correspondentId,
            @Parameter(name = "truncate_content", in = ParameterIn.QUERY)
                    @Valid
                    @RequestParam(value = "truncate_content", required = false)
                    Boolean truncateContent) {
        return new ResponseEntity<>(new GetDocuments200Response(), HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/documents/post_document/",
            consumes = {"multipart/form-data"})
    default ResponseEntity<Void> uploadDocument(
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
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
