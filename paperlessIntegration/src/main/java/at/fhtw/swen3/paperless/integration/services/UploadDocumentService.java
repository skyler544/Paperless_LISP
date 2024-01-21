package at.fhtw.swen3.paperless.integration.services;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import lombok.NoArgsConstructor;
import org.springframework.web.client.RestTemplate;

@NoArgsConstructor
@Service
public class UploadDocumentService {
    Logger logger = LogManager.getLogger(UploadDocumentService.class);

    @Value("${server.hostname}")
    private String serverAddress;
    @Value("${server.port}")
    private String port;
    @Value("${post_document.endpoint}")
    private String endpoint;

    @Value("${filepath}")
    private String filepath;

    @Value("${filename}")
    private String filename;

    private String address() {
        return "http://" + this.serverAddress + this.port + this.endpoint;
    }

    private FileSystemResource fileContent() throws IOException {
        var file = new File(filepath + filename);
        return new FileSystemResource(file);
    }

    public void uploadDocument() {
        String message = upload() == HttpStatus.CREATED ? "Successfully uploaded document."
                : "Failed to upload document.";

        this.logger.info(message);
    }

    private HttpStatus upload() {
        this.logger.info("Uploading document to: " + this.address());

        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            // we need to use this format to satisfy the type constraints on this endpoint
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("title", filename);
            body.add("document", fileContent());

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            return HttpStatus.valueOf(new RestTemplate().exchange(this.address(), HttpMethod.POST,
                    requestEntity, String.class).getStatusCode().value());

        } catch (Exception e) {
            this.logger.error(e);
        }

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
