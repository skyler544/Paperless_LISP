package at.fhtw.swen3.paperless.services.mapper;

import at.fhtw.swen3.paperless.models.entity.DocumentEntity;
import at.fhtw.swen3.paperless.services.dto.Document;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PostDocumentMapper {
    PostDocumentMapper INSTANCE = Mappers.getMapper(PostDocumentMapper.class);

    DocumentEntity dtoToEntity(Document document);
}
