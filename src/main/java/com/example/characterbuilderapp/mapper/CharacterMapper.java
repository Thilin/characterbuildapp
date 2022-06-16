package com.example.characterbuilderapp.mapper;

import com.example.characterbuilderapp.infra.db.msql.data.character.CharacterModel;
import com.example.characterbuilderapp.dto.CharacterResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CharacterMapper {

    public static final CharacterMapper INSTANCE = Mappers.getMapper(CharacterMapper.class);

    public abstract CharacterResponse mapToDTO(CharacterModel character);
}
