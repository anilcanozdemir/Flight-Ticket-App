package com.code16.Service.Contrats;

import com.code16.Core.Result.DataResult;
import com.code16.Core.Result.Result;

import java.util.List;

public interface BaseService<EntityResponseDto, EntityAddDto, EntityUpdateDto> {
    Result add(EntityAddDto entityAddDto);

    DataResult<EntityResponseDto> deleteByid(Long id);

    DataResult<List<EntityResponseDto>> getAll();

    DataResult<EntityResponseDto> getById(Long id);

    Result updateById(EntityUpdateDto entityUpdateDto);


}
