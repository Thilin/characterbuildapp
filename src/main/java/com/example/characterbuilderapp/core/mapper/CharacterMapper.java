package com.example.characterbuilderapp.core.mapper;

import com.example.characterbuilderapp.core.operations.character.FindCharacterDetailsOperation;
import com.example.characterbuilderapp.core.operations.job.ListCharacterJobsOperation;
import com.example.characterbuilderapp.domain.character.Character;
import com.example.characterbuilderapp.dto.CharacterDetailsResponse;
import com.example.characterbuilderapp.dto.CharactersListResponse;
import com.example.characterbuilderapp.infra.db.msql.data.character.CharacterModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CharacterMapper {

    public static final CharacterMapper INSTANCE = Mappers.getMapper(CharacterMapper.class);

    @Mapping(target = "character.id", source = "id")
    public abstract FindCharacterDetailsOperation mapToOperation(Long id);

    public abstract Character mapToDomain(CharacterModel model);

    public abstract CharactersListResponse mapToResponse(Character operation);

    @Mapping(target = "characterId", source = "id")
    public abstract ListCharacterJobsOperation mapToListCharacterJobsOperation(Long id);

    @Mapping(target = "id", source = "character.id")
    @Mapping(target = "name", source = "character.name")
    @Mapping(target = "image", source = "character.image")
    @Mapping(target = "rarity", source = "character.rarity")
    @Mapping(target = "element", source = "character.element")
    public abstract CharacterDetailsResponse mapToCharacterDetailsResponse(FindCharacterDetailsOperation operation);
}
