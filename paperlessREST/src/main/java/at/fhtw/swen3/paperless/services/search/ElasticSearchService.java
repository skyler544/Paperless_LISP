package at.fhtw.swen3.paperless.services.search;

import at.fhtw.swen3.paperless.config.ElasticSearchClientConfig;
import at.fhtw.swen3.paperless.models.entity.DocumentEntity;
import at.fhtw.swen3.paperless.services.DocumentService;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ElasticSearchService implements SearchService {

    Logger logger = LogManager.getLogger(DocumentService.class);

    private final ElasticsearchClient elasticsearchClient;

    public ElasticSearchService(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    @Override
    public List<DocumentEntity> searchDocumentsByQuery(String query) throws IOException {
        //search document with query
        try {
            SearchResponse<DocumentEntity> searchResponse = this.elasticsearchClient.search(s -> s
                    .index(ElasticSearchClientConfig.SEARCH_DOC_INDEX_NAME)
                    .query(q -> q
                            .multiMatch(
                                    m -> m.fields("content", "title").fuzziness("AUTO").query(query)
                            )), DocumentEntity.class);
//                            .match(t -> t
//                                    .field("content")
//                                    .query(query))), DocumentEntity.class);

            return searchResponse.hits().hits().stream().map(hit -> hit.source()).toList();
        } catch (IOException e) {
            logger.error("Error searching for documents \n" + e.getMessage());
            throw e;
        }

    }
}
