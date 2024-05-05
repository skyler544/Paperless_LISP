package at.fhtw.swen3.paperless.controller;

import at.fhtw.swen3.paperless.services.dto.*;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Validated
@Controller
public interface ConfigApi {
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/ui_settings/",
            produces = {"application/json"},
            consumes = {"application/json"})
    default ResponseEntity<Http200Response> createUISettings(
            @Valid @RequestBody(required = false) CreateUISettingsRequest createUISettingsRequest) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/saved_views/",
            produces = {"application/json"})
    default ResponseEntity<GetSavedViews200Response> getSavedViews(
            @Valid @RequestParam(value = "page", required = false) Integer page,
            @Valid @RequestParam(value = "page_size", required = false) Integer pageSize) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/ui_settings/",
            produces = {"application/json"})
    default ResponseEntity<GetUISettings200Response> getUISettings() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
