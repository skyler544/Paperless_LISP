package at.fhtw.swen3.paperless.services.search;

import at.fhtw.swen3.paperless.models.entity.DocumentEntity;

import java.io.IOException;
import java.util.List;

public interface SearchService {

    List<DocumentEntity> searchDocumentsByQuery(String query) throws IOException;

}
