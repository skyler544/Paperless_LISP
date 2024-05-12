package at.fhtw.swen3.paperless.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SearchApiController implements SearchApi, BaseLoggingController {
    private final Logger logger = LogManager.getLogger(ConfigApiController.class);

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public ResponseEntity<List<String>> autoComplete(String term, Integer limit) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
