package com.example.characterbuilderapp.mapper;

import com.example.characterbuilderapp.infra.db.msql.data.reaction.ReactionModel;
import com.example.characterbuilderapp.dto.ReactionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ReactionMapper {

    public static final ReactionMapper INSTANCE = Mappers.getMapper(ReactionMapper.class);

    public abstract ReactionResponse mapToDTO(ReactionModel reaction);
}
