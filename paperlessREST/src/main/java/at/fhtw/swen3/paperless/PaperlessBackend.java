package at.fhtw.swen3.paperless;

import com.fasterxml.jackson.databind.Module;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

@SpringBootApplication(
    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@ComponentScan(
    basePackages = {"at.fhtw.swen3.paperless.services", "at.fhtw.swen3.paperless.controller" , "at.fhtw.swen3.paperless.config", "at.fhtw.swen3.paperless.repositories"},
    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@EntityScan(
        basePackages = {"at.fhtw.swen3.paperless.models.entity"}
)
public class PaperlessBackend {

    public static void main(String[] args) {
        SpringApplication.run(PaperlessBackend.class, args);
    }

    @Bean(name = "at.fhtw.swen3.paperless.PaperlessBackend.jsonNullableModule")
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}
