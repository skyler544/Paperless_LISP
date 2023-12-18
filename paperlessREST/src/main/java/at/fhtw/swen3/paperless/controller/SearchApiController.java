package at.fhtw.swen3.paperless.controller;


import jakarta.annotation.Generated;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
public class SearchApiController implements SearchApi, BaseLoggingController {

    private final Logger logger = LogManager.getLogger(ConfigApiController.class);

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    private final NativeWebRequest request;

    @Autowired
    public SearchApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<String>> autoComplete(String term, Integer limit) {

        this.logReceivedRequest("Autocomplete");
        this.logIncomingParams(String.format("term: %s, limit: %s", term, limit.toString()));

        final List<String> autocompleteResult = new ArrayList<String>();

        this.logSentResponse("Autocomplete", autocompleteResult.toString());

        return new ResponseEntity<>(autocompleteResult, HttpStatus.NOT_IMPLEMENTED);
    }
}
