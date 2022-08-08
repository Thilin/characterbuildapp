package com.example.characterbuilderapp.core.mapper;

import com.example.characterbuilderapp.domain.build.CharacterBuildJob;
import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltJobModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CharacterBuiltJobMapper {

    public static final CharacterBuiltJobMapper INSTANCE = Mappers.getMapper(CharacterBuiltJobMapper.class);

    public abstract CharacterBuiltJobModel mapToModel(CharacterBuildJob characterBuildJob);
}
