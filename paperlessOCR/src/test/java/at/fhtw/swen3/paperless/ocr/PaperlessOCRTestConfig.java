package at.fhtw.swen3.paperless.ocr;

import at.fhtw.swen3.paperless.ocr.config.ElasticSearchClientConfig;
import at.fhtw.swen3.paperless.ocr.services.*;
import org.mockito.Mockito;
import org.springframework.context.annotation.*;

//Configure to return mocks for given classes --> useful for transitive dependencies
@Profile("test")
@Configuration
public class PaperlessOCRTestConfig {

    @Bean
    @Primary
    public ConsumerService consumerService() {
        return Mockito.mock(ConsumerService.class);
    }

//    @Bean
//    @Primary
//    public DocumentPostgresService documentPostgresService() {
//        return Mockito.mock(DocumentPostgresService.class);
//    }

    @Bean
    @Primary
    public ElasticSearchService elasticSearchService() {
        return Mockito.mock(ElasticSearchService.class);
    }

    @Bean
    @Primary
    public MinioService minioService() {
        return Mockito.mock(MinioService.class);
    }

    @Bean
    @Primary
    public OcrDispatcherService ocrDispatcherService() {
        return Mockito.mock(OcrDispatcherService.class);
    }

    @Bean
    @Primary
    public TesseractService tesseractService() {
        return Mockito.mock(TesseractService.class);
    }

    @Bean
    @Primary
    public ElasticSearchClientConfig elasticSearchClientConfig() {
        return Mockito.mock(ElasticSearchClientConfig.class);
    }
}
