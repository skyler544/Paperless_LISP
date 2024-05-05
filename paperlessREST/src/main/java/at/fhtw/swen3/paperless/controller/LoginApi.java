package at.fhtw.swen3.paperless.controller;

import at.fhtw.swen3.paperless.services.dto.Statistics200Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Validated
@Controller
public interface LoginApi {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/statistics/",
            produces = {"application/json"})
    default ResponseEntity<Statistics200Response> statistics() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
