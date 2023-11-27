package at.fhtw.swen3.paperless.controller;

import at.fhtw.swen3.paperless.services.dto.CreateSavedViewsRequest;
import at.fhtw.swen3.paperless.services.dto.CreateUISettings200Response;
import at.fhtw.swen3.paperless.services.dto.CreateUISettingsRequest;
import at.fhtw.swen3.paperless.services.dto.GetSavedViews200Response;
import at.fhtw.swen3.paperless.services.dto.GetUISettings200Response;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-26T19:12:48.175385Z[Etc/UTC]")
@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
public class ConfigApiController implements ConfigApi {

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
        GetUISettings200Response responseDTO = new GetUISettings200Response();
        responseDTO.setDisplayName("Test User");

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CreateUISettings200Response> createUISettings(CreateUISettingsRequest createUISettingsRequest) {

        CreateUISettings200Response responseDTO = new CreateUISettings200Response();
        responseDTO.setSuccess(true);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<GetSavedViews200Response> getSavedViews(Integer page, Integer pageSize) {

        GetSavedViews200Response response = new GetSavedViews200Response();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
