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

    public boolean successfullyQueriedDocument() {
        if (queryDocument() == HttpStatus.OK) {
            this.logger.info("Successfully queried document.");
            return true;
        } else {
            this.logger.error("Failed to query document.");
            return false;
        }
    }

    private HttpStatus queryDocument() {
        this.logger.info("Querying for: [" + query + "] at: " + this.address());

        try {
            String url = UriComponentsBuilder.fromUriString(this.address())
                    .queryParam("query", query)
                    .build()
                    .toUriString();

            this.logger.info("Query url: " + url);
            this.logger.info(url);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
            ResponseEntity<String> responseEntity = new RestTemplate().exchange(url, HttpMethod.GET, requestEntity,
                    String.class);

            this.logger.info(responseEntity.toString());

            return HttpStatus.valueOf(responseEntity.getStatusCode().value());
        } catch (Exception e) {
            this.logger.error(e);
        }

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
