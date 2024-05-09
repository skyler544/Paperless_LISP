package at.fhtw.swen3.paperless.controller;

import at.fhtw.swen3.paperless.services.dto.Statistics200Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class LoginApiController implements LoginApi, BaseLoggingController {

    private final Logger logger = LogManager.getLogger(ConfigApiController.class);

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public ResponseEntity<Statistics200Response> statistics() {
        this.logReceivedRequest("GetStatistics");
        Statistics200Response responseDTO = new Statistics200Response();
        this.logSentResponse("GetStatistics", responseDTO.toString());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
