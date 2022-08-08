package com.example.characterbuilderapp.core.mapper;

import com.example.characterbuilderapp.domain.character.CharacterJob;
import com.example.characterbuilderapp.infra.db.msql.data.character.CharacterJobModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CharacterJobMapper {

    public static final CharacterJobMapper INSTANCE = Mappers.getMapper(CharacterJobMapper.class);

    public abstract CharacterJob mapToDomain(CharacterJobModel model);
}
