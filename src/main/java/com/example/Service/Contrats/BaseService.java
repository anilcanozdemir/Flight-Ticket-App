package com.example.Service.Contrats;

import com.example.Core.Result.DataResult;
import com.example.Core.Result.Result;

import java.util.List;

public interface BaseService<EntityResponseDto, EntityAddDto, EntityUpdateDto> {
    Result add(EntityAddDto entityAddDto);

    DataResult<EntityResponseDto> deleteByid(Long id);

    DataResult<List<EntityResponseDto>> getAll();

    DataResult<EntityResponseDto> getById(Long id);

    Result updateById(EntityUpdateDto entityUpdateDto);


}
