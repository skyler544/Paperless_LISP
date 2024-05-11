package at.fhtw.swen3.paperless.services.minio;

import org.springframework.web.multipart.MultipartFile;

public interface DocumentStoreService {

    void handleFileUpload(MultipartFile document);

}
