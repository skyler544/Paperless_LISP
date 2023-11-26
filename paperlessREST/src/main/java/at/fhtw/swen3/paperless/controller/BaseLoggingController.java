package at.fhtw.swen3.paperless.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseLoggingController {

    protected final Logger logger = LogManager.getLogger(BaseLoggingController.class);

    protected final void logReceivedRequest(String endpointName) {

        this.logger.info(String.format("Received request %s", endpointName));

    }

    protected final void logIncomingParams(String parametersAsString) {

        this.logger.info(String.format("With parameters: \n %s", parametersAsString));

    }

    protected final void logSentResponse(String endpointName, String responseAsString) {

        this.logger.info(String.format("Endpoint [%s] sending response: \n %s",endpointName, responseAsString));

    }

}
