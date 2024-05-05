package at.fhtw.swen3.paperless.controller;

import at.fhtw.swen3.paperless.services.dto.Http200Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
public class TasksApiController implements TasksApi, BaseLoggingController {
    private final Logger logger = LogManager.getLogger(ConfigApiController.class);

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public ResponseEntity<List<Http200Response>> getTasks() {
        this.logReceivedRequest("GetTasks");

        List<Http200Response> responseDTO = new ArrayList<>();

        this.logSentResponse("GetTasks", responseDTO.toString());

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
