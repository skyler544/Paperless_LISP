package at.fhtw.swen3.paperless;

import at.fhtw.swen3.paperless.config.ElasticSearchClientConfig;
import at.fhtw.swen3.paperless.services.DispatcherService;
import at.fhtw.swen3.paperless.services.document.DocumentService;
import at.fhtw.swen3.paperless.services.minio.MinioService;
import at.fhtw.swen3.paperless.services.search.ElasticSearchService;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class SpringContextTestConfig {

    @Bean
    @Primary
    public DocumentService documentService() {
        return Mockito.mock(DocumentService.class);
    }

    @Bean
    @Primary
    public DispatcherService dispatcherService() {
        return Mockito.mock(DispatcherService.class);
    }

    @Bean
    @Primary
    public ElasticSearchService elasticSearchService() {
        return Mockito.mock(ElasticSearchService.class);
    }

    @Bean
    @Primary
    public ElasticSearchClientConfig elasticSearchClientConfig() {
        return Mockito.mock(ElasticSearchClientConfig.class);
    }

    @MockBean
    MinioService minioService;

    @MockBean
    ElasticsearchClient elasticsearchClient;

}
