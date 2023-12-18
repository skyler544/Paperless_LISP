package at.fhtw.swen3.paperless.controller;

import at.fhtw.swen3.paperless.services.dto.GetTasks200ResponseInner;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-03T12:56:46.892911Z[Etc/UTC]")
@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
public class TasksApiController implements TasksApi, BaseLoggingController {

    private final Logger logger = LogManager.getLogger(ConfigApiController.class);

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    private final NativeWebRequest request;

    @Autowired
    public TasksApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<GetTasks200ResponseInner>> getTasks() {

        this.logReceivedRequest("GetTasks");

        List<GetTasks200ResponseInner> responseDTO = new ArrayList<GetTasks200ResponseInner>();

        this.logSentResponse("GetTasks", responseDTO.toString());

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
