package com.example.characterbuilderapp.mapper;

import com.example.characterbuilderapp.infra.db.msql.data.esper.EsperModel;
import com.example.characterbuilderapp.dto.EsperResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class EsperMapper {

    public static final EsperMapper INSTANCE = Mappers.getMapper(EsperMapper.class);

    public abstract EsperResponse mapToDTO(EsperModel esper);
}
