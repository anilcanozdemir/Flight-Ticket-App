package com.example.Service.Contrats;

import java.util.List;

public interface BaseService<EntityResponseDto,EntityAddDto,EntityUpdateDto> {
    void add(EntityAddDto entityAddDto);
    EntityResponseDto deleteByid(Long id);
    List<EntityResponseDto> getAll();

    EntityResponseDto getById(Long id);
    void updateById(EntityUpdateDto entityUpdateDto);



}
