package at.fhtw.swen3.paperless.integration.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegrationDispatcherService {
    Logger logger = LogManager.getLogger(IntegrationDispatcherService.class);

    private final HealthCheckerService healthCheckerService;
    private final UploadDocumentService uploadDocumentService;

    @Autowired
    public IntegrationDispatcherService(HealthCheckerService healthCheckerService, UploadDocumentService uploadDocumentService) {
        this.healthCheckerService = healthCheckerService;
        this.uploadDocumentService = uploadDocumentService;
    }

    public void integrationTests() throws Exception {
        this.logger.info("Beginning Integration Testing:");

        // do nothing until the application is ready
        while(!healthCheckerService.isHealthy()) {}
        this.logger.info("The server is awake and ready. Proceeding.");

        this.uploadDocumentService.uploadDocument();
    }
}
