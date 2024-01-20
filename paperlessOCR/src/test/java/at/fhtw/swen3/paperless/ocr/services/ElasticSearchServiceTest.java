package at.fhtw.swen3.paperless.ocr.services;

import at.fhtw.swen3.paperless.ocr.entities.DocumentEntity;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.util.ObjectBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.function.Function;

import static org.mockito.ArgumentMatchers.any;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ElasticSearchServiceTest {

    @Mock
    private ElasticsearchClient elasticsearchClient;

    @InjectMocks
    private ElasticSearchService elasticSearchService;

    @Test
    public void whenIndexCalledClientSendsRequest() {

        try {

            DocumentEntity doc = new DocumentEntity();
            doc.setId(1);
            doc.setContent("Document content");
            elasticSearchService.indexDocument(doc);

            //since we create the request as a lambda we have to use the any() to just see if the method is called
            Mockito.verify(elasticsearchClient, Mockito.times(1)).index((Function<IndexRequest.Builder<Object>, ObjectBuilder<IndexRequest<Object>>>) any());

        } catch (Exception e) {
            System.out.printf(e.getMessage());
            throw new RuntimeException(e);
        }

    }

}