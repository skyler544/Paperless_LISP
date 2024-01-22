package at.fhtw.swen3.paperless.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import at.fhtw.swen3.paperless.integration.services.IntegrationDispatcherService;

@SpringBootApplication
public class Main implements CommandLineRunner {
    Logger logger = LogManager.getLogger(Main.class);

    @Autowired
    IntegrationDispatcherService dispatcher;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args).close();
    }

    @Override
    public void run(String... args) throws Exception {
        dispatcher.integrationTests();
    }
}
