package at.fhtw.swen3.paperless.integration.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
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

    public String address() {
        return "http://" + this.serverAddress + this.port + this.endpoint;
    }

    public boolean isHealthy() {
        return this.getResponseCode() == HttpStatus.OK;
    }

    private HttpStatus getResponseCode() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            return HttpStatus.valueOf(restTemplate.getForEntity(this.address(), String.class)
                    .getStatusCode().value());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
