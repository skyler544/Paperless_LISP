package at.fhtw.swen3.paperless.ocr.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.openapitools.jackson.nullable.JsonNullableModule;

@Configuration
public class ElasticSearchClientConfig {

    public static final String SEARCH_DOC_INDEX_NAME = "docs";

    @Value("${elasticsearch.host}")
    private String host;
    @Value("${elasticsearch.port}")
    private int port;

    @Bean
    public RestClient getRestClient() {
        return RestClient.builder(
                new HttpHost(host, port)).build();
    }

    @Bean
    public ElasticsearchTransport getElasticsearchTransport() {
        JacksonJsonpMapper mapper = new JacksonJsonpMapper();
        mapper.objectMapper().registerModule(new JavaTimeModule());
        mapper.objectMapper().registerModule(new JsonNullableModule());
        return new RestClientTransport(
                getRestClient(), mapper);
    }


    @Bean
    public ElasticsearchClient getElasticsearchClient(){
        return new ElasticsearchClient(getElasticsearchTransport());
    }

}
