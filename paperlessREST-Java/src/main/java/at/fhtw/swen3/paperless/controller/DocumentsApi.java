package at.fhtw.swen3.paperless.controller;

import at.fhtw.swen3.paperless.services.dto.*;

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
            @PathVariable("id") Integer id,
            @Valid @RequestParam(value = "page", required = false) Integer page,
            @Valid @RequestParam(value = "full_perms", required = false) Boolean fullPerms) {
        return new ResponseEntity<>(new GetDocument200Response(), HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/documents/",
            produces = {"application/json"})
    default ResponseEntity<GetDocuments200Response> getDocuments(
            @Valid @RequestParam(value = "Page", required = false) Integer page,
            @Valid @RequestParam(value = "page_size", required = false) Integer pageSize,
            @Valid @RequestParam(value = "query", required = false) String query,
            @Valid @RequestParam(value = "ordering", required = false) String ordering,
            @Valid @RequestParam(value = "tags__id__all", required = false) List<Integer> tagsIdAll,
            @Valid @RequestParam(value = "document_type__id", required = false)
                    Integer documentTypeId,
            @Valid @RequestParam(value = "storage_path__id__in", required = false)
                    Integer storagePathIdIn,
            @Valid @RequestParam(value = "correspondent__id", required = false)
                    Integer correspondentId,
            @Valid @RequestParam(value = "truncate_content", required = false)
                    Boolean truncateContent) {
        return new ResponseEntity<>(new GetDocuments200Response(), HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/documents/post_document/",
            consumes = {"multipart/form-data"})
    default ResponseEntity<Void> uploadDocument(
            @Valid @RequestParam(value = "title", required = false) String title,
            @Valid
                    @RequestParam(value = "created", required = false)
                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                    OffsetDateTime created,
            @Valid @RequestParam(value = "document_type", required = false) Integer documentType,
            @Valid @RequestPart(value = "tags", required = false) List<Integer> tags,
            @Valid @RequestParam(value = "correspondent", required = false) Integer correspondent,
            @RequestPart(value = "document", required = false) List<MultipartFile> document) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
