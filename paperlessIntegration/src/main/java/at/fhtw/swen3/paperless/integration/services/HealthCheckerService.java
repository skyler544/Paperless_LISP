package at.fhtw.swen3.paperless.integration.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class HealthCheckerService {
    Logger logger = LogManager.getLogger(HealthCheckerService.class);

    @Value("${server.hostname}")
    private String serverAddress;
    @Value("${server.port}")
    private String port;
    @Value("${healthcheck.endpoint}")
    private String endpoint;

    public boolean isHealthy() {
        return this.getResponseCode() == HttpStatus.OK;
    }

    private String address() {
        return "http://" + this.serverAddress + this.port + this.endpoint;
    }

    private HttpStatus getResponseCode() {
        try {
            this.logger.info("Pinging server...");
            RestTemplate restTemplate = new RestTemplate();
            return HttpStatus.valueOf(restTemplate.getForEntity(this.address(), String.class)
                    .getStatusCode().value());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
