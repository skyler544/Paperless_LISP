package at.fhtw.swen3.paperless.services.mapper;

import at.fhtw.swen3.paperless.models.entity.DocumentEntity;
import at.fhtw.swen3.paperless.services.dto.PostDocumentRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.OffsetDateTime;
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = "spring")
public interface PostDocumentMapper extends BaseMapper<DocumentEntity, PostDocumentRequestDto> {
    PostDocumentMapper INSTANCE = Mappers.getMapper(PostDocumentMapper.class);

    @Mapping(source="title", target ="title")
    @Mapping(source="correspondent", target = "correspondent")
    @Mapping(source="documentType", target = "documentType")
    @Mapping(source="offsetDateTime", target = "createdDate", qualifiedByName = "parseOffSetToString")
    DocumentEntity dtoToEntity(PostDocumentRequestDto postDocumentRequestDto);

    @Named("parseOffSetToString")
    default String map(OffsetDateTime offsetDateTime) {
        return offsetDateTime.toString();
    }

}
