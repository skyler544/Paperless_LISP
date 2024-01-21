package at.fhtw.swen3.paperless.integration.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.Getter;
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

    public String address() {
        return "http://" + this.serverAddress + this.port + this.endpoint;
    }

    public boolean successfullyQueriedDocument() {
        return false;
    }

    private HttpStatus queryDocument() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
