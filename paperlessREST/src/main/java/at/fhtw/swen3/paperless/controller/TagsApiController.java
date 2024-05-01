package at.fhtw.swen3.paperless.controller;

import at.fhtw.swen3.paperless.services.dto.Http200Response;

import jakarta.annotation.Generated;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2023-11-03T13:46:03.125613Z[Etc/UTC]")
@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
public class TagsApiController implements TagsApi, BaseLoggingController {

    private final Logger logger = LogManager.getLogger(ConfigApiController.class);

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    private final NativeWebRequest request;

    @Autowired
    public TagsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Http200Response> getTags(Integer page, Boolean fullPerms) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
