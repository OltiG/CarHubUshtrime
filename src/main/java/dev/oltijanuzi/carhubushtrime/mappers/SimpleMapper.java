package dev.oltijanuzi.carhubushtrime.mappers;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SimpleMapper<TModel,TDto> {
    TDto toDto(TModel model);
    TModel toModel(TDto dto);

    List<TModel> toModels(List<TDto> dtos);
    List<TDto> toDtos(List<TModel> models);
}
