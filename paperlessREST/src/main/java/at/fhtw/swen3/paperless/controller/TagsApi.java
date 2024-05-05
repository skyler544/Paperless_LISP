package at.fhtw.swen3.paperless.controller;

import at.fhtw.swen3.paperless.services.dto.Http200Response;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Validated
@Controller
public interface TagsApi {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/tags/",
            produces = {"application/json"})
    default ResponseEntity<Http200Response> getTags(
            @Parameter(name = "page", in = ParameterIn.QUERY)
                    @Valid
                    @RequestParam(value = "page", required = false)
                    Integer page,
            @Parameter(name = "full_perms", in = ParameterIn.QUERY)
                    @Valid
                    @RequestParam(value = "full_perms", required = false)
                    Boolean fullPerms) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
