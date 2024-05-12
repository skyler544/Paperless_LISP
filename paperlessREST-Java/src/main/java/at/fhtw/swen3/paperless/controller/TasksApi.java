package at.fhtw.swen3.paperless.controller;

import at.fhtw.swen3.paperless.services.dto.Http200Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Validated
@Controller
public interface TasksApi {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/tasks/",
            produces = {"application/json"})
    default ResponseEntity<List<Http200Response>> getTasks() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
