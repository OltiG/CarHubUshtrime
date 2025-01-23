package dev.oltijanuzi.carhubushtrime.service;

import java.util.List;

// TDto - DTO, TId - DTO's ID (Profen) (mappimi behet ne service)
public interface BaseService<TDto, TId> {
    List<TDto> findAll();

    TDto findById(TId id);

    TDto add(TDto model);

    TDto modify(TId id, TDto model);

    void removeById(TId id);
}
