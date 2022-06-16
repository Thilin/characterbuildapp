package com.example.characterbuilderapp.mapper;

import com.example.characterbuilderapp.core.operations.supportability.SupportAbilityOperation;
import com.example.characterbuilderapp.domain.supportability.SupportAbility;
import com.example.characterbuilderapp.dto.SupportAbilityResponse;
import com.example.characterbuilderapp.infra.db.msql.data.supportability.SupportAbilityModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class SupportAbilityMapper {

    public static final SupportAbilityMapper INSTANCE = Mappers.getMapper(SupportAbilityMapper.class);

    public abstract SupportAbility mapToDomain(SupportAbilityModel model);

    @Mapping(target = "supportAbility.id", source = "id")
    public abstract SupportAbilityOperation mapToOperation(Long id);

    @Mapping(target = "id", source = "supportAbility.id")
    @Mapping(target = "description", source = "supportAbility.description")
    @Mapping(target = "job", source = "supportAbility.job")
    public abstract SupportAbilityResponse mapToResponse(SupportAbilityOperation operation);
}
