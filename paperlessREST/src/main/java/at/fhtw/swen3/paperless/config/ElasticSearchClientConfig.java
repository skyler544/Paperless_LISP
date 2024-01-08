package at.fhtw.swen3.paperless.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

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
    public ElasticsearchClient getElasticsearchClient() throws IOException {
        ElasticsearchClient client = new ElasticsearchClient(getElasticsearchTransport());

        //if index does not yet exist we create it, more elegant than in the appropriate service
        if (!client.indices().exists(
                i -> i.index(ElasticSearchClientConfig.SEARCH_DOC_INDEX_NAME)
        ).value()) {
            client.indices().create(c -> c
                    .index(ElasticSearchClientConfig.SEARCH_DOC_INDEX_NAME)
            );
        }

        return client;
    }

}
