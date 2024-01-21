package at.fhtw.swen3.paperless.integration.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import org.json.JSONObject;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class QueryDocumentService {
    Logger logger = LogManager.getLogger(HealthCheckerService.class);

    @Value("${server.hostname}")
    private String serverAddress;
    @Value("${server.port}")
    private String port;
    @Value("${get_document.endpoint}")
    private String endpoint;

    private String query = "hello";

    public String address() {
        return "http://" + this.serverAddress + this.port + this.endpoint;
    }

    public boolean successfullyQueriedDocuments() {
        if (queryDocuments() == HttpStatus.OK) {
            this.logger.info("Successfully queried documents.");
            return true;
        } else {
            this.logger.error("Failed to query documents.");
            return false;
        }
    }

    private HttpStatus queryDocuments() {
        this.logger.info("Querying for: [ " + query + " ] at: " + this.address());

        try {
            ResponseEntity<String> responseEntity = getResponseEntity();

            JSONObject response = new JSONObject(responseEntity.getBody());

            this.logger.info("Number of hits: " + response.get("count"));
            var results = response.getJSONArray("results");

            for (int i = 0; i < results.length(); i++) {
                JSONObject result = results.getJSONObject(i);
                this.logger.info("Result id: " + result.get("id"));
                this.logger.info("Result content: " + result.get("content"));
            }

            return HttpStatus.valueOf(responseEntity.getStatusCode().value());
        } catch (Exception e) {
            this.logger.error(e);
        }

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    private ResponseEntity<String> getResponseEntity() {
        String url = UriComponentsBuilder.fromUriString(this.address())
                .queryParam("query", query)
                .build()
                .toUriString();

        this.logger.info("Query url: " + url);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = new RestTemplate().exchange(url, HttpMethod.GET, requestEntity,
                String.class);
        return responseEntity;
    }
}
