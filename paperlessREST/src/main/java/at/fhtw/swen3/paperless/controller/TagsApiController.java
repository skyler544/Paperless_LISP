package at.fhtw.swen3.paperless.controller;

import at.fhtw.swen3.paperless.services.dto.Http200Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
public class TagsApiController implements TagsApi, BaseLoggingController {

    private final Logger logger = LogManager.getLogger(ConfigApiController.class);

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public ResponseEntity<Http200Response> getTags(Integer page, Boolean fullPerms) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
