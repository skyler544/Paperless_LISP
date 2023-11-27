package at.fhtw.swen3.paperless;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenApiGeneratorApplicationTests {

    Logger logger = LogManager.getLogger(OpenApiGeneratorApplicationTests.class);

    @Test
    void contextLoads() {

        //Test if logging info works
        logger.info("Logging on level info");

        //Test if logging error works
        logger.error("Logging on level error");
    }

}