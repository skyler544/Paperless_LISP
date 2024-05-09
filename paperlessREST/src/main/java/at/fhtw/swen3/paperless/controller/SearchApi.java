package at.fhtw.swen3.paperless.controller;


import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Validated
@Controller
public interface SearchApi {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/search/autocomplete/",
            produces = {"application/json"})
    default ResponseEntity<List<String>> autoComplete(
            @Valid @RequestParam(value = "term", required = false) String term,
            @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
