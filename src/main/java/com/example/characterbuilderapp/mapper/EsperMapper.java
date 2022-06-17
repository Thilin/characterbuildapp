package com.example.characterbuilderapp.mapper;

import com.example.characterbuilderapp.core.operations.esper.EsperOperation;
import com.example.characterbuilderapp.domain.esper.Esper;
import com.example.characterbuilderapp.dto.EsperResponse;
import com.example.characterbuilderapp.infra.db.msql.data.esper.EsperModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class EsperMapper {

    public static final EsperMapper INSTANCE = Mappers.getMapper(EsperMapper.class);

    @Mapping(target = "esper.id", source = "id")
    public abstract EsperOperation mapToOperation(Long id);

    @Mapping(target = "id", source = "esper.id")
    @Mapping(target = "name", source = "esper.name")
    @Mapping(target = "image", source = "esper.image")
    @Mapping(target = "rarity", source = "esper.rarity")
    @Mapping(target = "element", source = "esper.element")
    public abstract EsperResponse mapToResponse(EsperOperation operation);

    public abstract Esper mapToDomain(EsperModel model);
}
