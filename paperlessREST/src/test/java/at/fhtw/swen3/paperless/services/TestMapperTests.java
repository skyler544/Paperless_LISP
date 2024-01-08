package at.fhtw.swen3.paperless.services;

import at.fhtw.swen3.paperless.entities.TestEntity;
import at.fhtw.swen3.paperless.mapper.TestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMapperTests {
    @Test
    void EntityToDtoMapping() {
        var testEntity = TestEntity.builder()
                .id(1)
                .title("Test title")
                .content("This is a test")
                .build();

        var result = TestMapper.INSTANCE.entityToDto(testEntity);

        assertEquals(testEntity.getId(), result.getId());
        assertEquals(testEntity.getTitle(), result.getTitle());
        assertEquals(testEntity.getContent(), result.getContent());

    }
}
