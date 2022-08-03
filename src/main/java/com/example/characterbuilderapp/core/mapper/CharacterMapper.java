package com.example.characterbuilderapp.core.mapper;

import com.example.characterbuilderapp.core.operations.character.CharacterOperation;
import com.example.characterbuilderapp.core.operations.job.ListCharacterJobsOperation;
import com.example.characterbuilderapp.domain.character.Character;
import com.example.characterbuilderapp.dto.CharacterResponse;
import com.example.characterbuilderapp.infra.db.msql.data.character.CharacterModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CharacterMapper {

    public static final CharacterMapper INSTANCE = Mappers.getMapper(CharacterMapper.class);

    @Mapping(target = "character.id", source = "id")
    public abstract CharacterOperation mapToOperation(Long id);

    public abstract Character mapToDomain(CharacterModel model);

    public abstract CharacterResponse mapToResponse(Character operation);

    @Mapping(target = "characterId", source = "id")
    public abstract ListCharacterJobsOperation mapToListCharacterJobsOperation(Long id);
}
