package at.fhtw.swen3.paperless.controller;

import org.apache.logging.log4j.Logger;

public interface BaseLoggingController {
    Logger getLogger();

    default void logReceivedRequest(String endpointName) {
        this.getLogger().info(String.format("Received request %s", endpointName));
    }

    default void logIncomingParams(String parametersAsString) {
        this.getLogger().info(String.format("With parameters: \n %s", parametersAsString));
    }

    default void logSentResponse(String endpointName, String responseAsString) {
        String logMessage =
                String.format(
                        "Endpoint [%s] sending response: \n %s", endpointName, responseAsString);
        this.getLogger().info(logMessage);
    }
}
