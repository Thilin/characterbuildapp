package com.example.characterbuilderapp.core.mapper;

import com.example.characterbuilderapp.core.operations.reaction.ReactionOperation;
import com.example.characterbuilderapp.domain.reaction.Reaction;
import com.example.characterbuilderapp.dto.ReactionResponse;
import com.example.characterbuilderapp.infra.db.msql.data.reaction.ReactionModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ReactionMapper {

    public static final ReactionMapper INSTANCE = Mappers.getMapper(ReactionMapper.class);

    public abstract Reaction mapToDomain(ReactionModel model);

    @Mapping(target = "reaction.id", source = "id")
    public abstract ReactionOperation mapToOperation(Long id);

    public abstract ReactionResponse mapToResponse(Reaction operation);
}
