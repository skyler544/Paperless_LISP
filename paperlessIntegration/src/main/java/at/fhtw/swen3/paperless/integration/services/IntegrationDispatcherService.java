package at.fhtw.swen3.paperless.integration.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegrationDispatcherService {
    Logger logger = LogManager.getLogger(IntegrationDispatcherService.class);

    private final HealthCheckerService healthCheckerService;

    @Autowired
    public IntegrationDispatcherService(HealthCheckerService healthCheckerService) {
        this.healthCheckerService = healthCheckerService;
    }

    public void integrationTests() {
        this.logger.info("We're integrating now boys.");

        this.logger.info("Healthy? " + this.healthCheckerService.isHealthy());
    }
}
