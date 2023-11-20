package at.fhtw.swen3.paperless.services;
import at.fhtw.swen3.paperless.models.entity.DocumentEntity;
import at.fhtw.swen3.paperless.services.dto.GetDocument200Response;
import at.fhtw.swen3.paperless.services.dto.PostDocumentRequestDto;
import at.fhtw.swen3.paperless.services.mapper.DocumentMapper;
import at.fhtw.swen3.paperless.services.mapper.PostDocumentMapper;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PostDocumentMapperTests {

    @Test
    void PostDocumentRequestDtoIsMappedToDocumentEntity() {
        PostDocumentRequestDto postDocumentRequestDto = new PostDocumentRequestDto();
        postDocumentRequestDto.setTitle("Test Title");
        postDocumentRequestDto.setOffsetDateTime(OffsetDateTime.now());
        postDocumentRequestDto.setDocumentType(1);
        postDocumentRequestDto.setTags(List.of(1,2,3));
        postDocumentRequestDto.setCorrespondent(2);
        postDocumentRequestDto.setDocumentContentBase64("I am a 64 encoded content");

        var result = PostDocumentMapper.INSTANCE.dtoToEntity(postDocumentRequestDto);

        assertEquals(postDocumentRequestDto.getTitle(), result.getTitle());
        assertNotEquals(null, result.getCreatedDate());
        assertEquals(postDocumentRequestDto.getDocumentType(), result.getDocumentType());
        assertEquals(postDocumentRequestDto.getCorrespondent(), result.getCorrespondent());
        assertEquals(postDocumentRequestDto.getDocumentContentBase64(), result.getContent());

    }
}
