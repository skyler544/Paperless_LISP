package at.fhtw.swen3.paperless.mapper;


import at.fhtw.swen3.paperless.DTOs.TestDto;
import at.fhtw.swen3.paperless.entities.TestEntity;
import at.fhtw.swen3.paperless.services.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = "spring")
public interface TestMapper extends BaseMapper<TestEntity, TestDto> {
    TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);


    @Mapping(source="id", target = "id")
    @Mapping(source="title", target = "title")
    @Mapping(source="content", target = "content")
    TestDto entityToDto(TestEntity testEntity);

}

