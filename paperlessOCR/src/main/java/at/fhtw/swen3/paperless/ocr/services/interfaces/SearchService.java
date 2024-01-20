package at.fhtw.swen3.paperless.ocr.services.interfaces;

import at.fhtw.swen3.paperless.ocr.entities.DocumentEntity;
import co.elastic.clients.elasticsearch._types.Result;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface SearchService {

    Result indexDocument(DocumentEntity document) throws IOException;

}
