package com.example.characterbuilderapp.mapper;

import com.example.characterbuilderapp.infra.db.msql.data.supportability.SupportAbilityModel;
import com.example.characterbuilderapp.dto.SupportAbilityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class SupportAbilityMapper {

    public static final SupportAbilityMapper INSTANCE = Mappers.getMapper(SupportAbilityMapper.class);

    public abstract SupportAbilityResponse mapToDTO(SupportAbilityModel supportAbility);
}
