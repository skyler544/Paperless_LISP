package at.fhtw.swen3.paperless.ocr.services;

import at.fhtw.swen3.paperless.ocr.config.ElasticSearchClientConfig;
import at.fhtw.swen3.paperless.ocr.entities.DocumentEntity;
import at.fhtw.swen3.paperless.ocr.services.interfaces.SearchService;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.Result;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.watcher.IndexResult;
import jdk.jshell.spi.ExecutionControl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ElasticSearchService implements SearchService {

    final Logger logger = LogManager.getLogger(OcrDispatcherService.class);

    private final ElasticsearchClient elasticsearchClient;

    public ElasticSearchService(ElasticsearchClient elasticsearchClient) throws IOException {

        this.elasticsearchClient = elasticsearchClient;

    }

    @Override
    public Result indexDocument(DocumentEntity document) throws IOException {
        //index the document in the elastic search db
        try {
            IndexResponse indexResponse = this.elasticsearchClient.index(indexRequest -> indexRequest
                    .index(ElasticSearchClientConfig.SEARCH_DOC_INDEX_NAME)
                    .id(document.getId().toString())
                    .document(document)
            );

            if (indexResponse.result()!=Result.Created && indexResponse.result()!=Result.Updated) {
                logger.log(Level.ERROR, String.format("Error indexing document [DocId: %s, DocTitle: %s]", document.getId().toString(), document.getTitle()));
            }
            else {
                logger.log(Level.INFO, String.format("Indexed document into search db. [DocId: %s, DocTitle: %s]", document.getId().toString(), document.getTitle()));
            }

            return indexResponse.result();

        } catch (IOException e) {
            logger.log(Level.ERROR, "Failed to index document in the search db \n" + e.getMessage());
            throw e;
        }

    }

}
