package at.fhtw.swen3.paperless.controller;

import at.fhtw.swen3.paperless.services.dto.*;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Validated
@Controller
public interface ConfigApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/saved_views/
     *
     * @param createSavedViewsRequest (optional)
     * @return Success (status code 200)
     */
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/saved_views/",
            consumes = {"application/json"})
    default ResponseEntity<Void> createSavedViews(
            @Parameter(name = "CreateSavedViewsRequest", description = "")
                    @Valid
                    @RequestBody(required = false)
                    CreateSavedViewsRequest createSavedViewsRequest) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * POST /api/ui_settings/
     *
     * @param createUISettingsRequest (optional)
     * @return Success (status code 200)
     */
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/ui_settings/",
            produces = {"application/json"},
            consumes = {"application/json"})
    default ResponseEntity<Http200Response> createUISettings(
            @Parameter(name = "CreateUISettingsRequest", description = "")
                    @Valid
                    @RequestBody(required = false)
                    CreateUISettingsRequest createUISettingsRequest) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * GET /ws/status/
     *
     * @return Success (status code 200)
     */
    @RequestMapping(method = RequestMethod.GET, value = "/ws/status/")
    default ResponseEntity<Void> get() {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * GET /api/saved_views/
     *
     * @param page (optional)
     * @param pageSize (optional)
     * @return Success (status code 200)
     */
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/saved_views/",
            produces = {"application/json"})
    default ResponseEntity<Http200Response> getSavedViews(
            @Parameter(name = "page", description = "", in = ParameterIn.QUERY)
                    @Valid
                    @RequestParam(value = "page", required = false)
                    Integer page,
            @Parameter(name = "page_size", description = "", in = ParameterIn.QUERY)
                    @Valid
                    @RequestParam(value = "page_size", required = false)
                    Integer pageSize) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * GET /api/ui_settings/
     *
     * @return Success (status code 200)
     */
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/ui_settings/",
            produces = {"application/json"})
    default ResponseEntity<Http200Response> getUISettings() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
