package at.fhtw.swen3.paperless.controller;

import at.fhtw.swen3.paperless.services.dto.CreateUISettings200Response;
import at.fhtw.swen3.paperless.services.dto.CreateUISettingsRequest;
import at.fhtw.swen3.paperless.services.dto.GetSavedViews200Response;
import at.fhtw.swen3.paperless.services.dto.GetUISettings200Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;


import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
public class ConfigApiController implements ConfigApi, BaseLoggingController {

    private final Logger logger = LogManager.getLogger(ConfigApiController.class);

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    private final NativeWebRequest request;

    @Autowired
    public ConfigApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<GetUISettings200Response> getUISettings() {

        this.logReceivedRequest("GetUISettings");

        GetUISettings200Response responseDTO = new GetUISettings200Response();
        responseDTO.setDisplayName("Test User");

        this.logSentResponse("GetUISettings", responseDTO.toString());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CreateUISettings200Response> createUISettings(CreateUISettingsRequest createUISettingsRequest) {

        this.logReceivedRequest("CreateUISettings");
        this.logIncomingParams(createUISettingsRequest.toString());

        CreateUISettings200Response responseDTO = new CreateUISettings200Response();
        responseDTO.setSuccess(true);

        this.logSentResponse("CreateUISettings", responseDTO.toString());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<GetSavedViews200Response> getSavedViews(Integer page, Integer pageSize) {

        this.logReceivedRequest("GetSavedViews");
        GetSavedViews200Response responseDTO = new GetSavedViews200Response();

        this.logSentResponse("GetSavedViews", responseDTO.toString());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }
}
