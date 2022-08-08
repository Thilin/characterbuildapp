package com.example.characterbuilderapp.core.mapper;

import com.example.characterbuilderapp.domain.build.CharacterBuildSupportAbility;
import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltSupportAbilityModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CharacterBuiltSupportAbilityMapper {

    public static final CharacterBuiltSupportAbilityMapper INSTANCE = Mappers.getMapper(CharacterBuiltSupportAbilityMapper.class);

    public abstract CharacterBuiltSupportAbilityModel mapToModel(CharacterBuildSupportAbility characterBuildSupportAbility);
}
