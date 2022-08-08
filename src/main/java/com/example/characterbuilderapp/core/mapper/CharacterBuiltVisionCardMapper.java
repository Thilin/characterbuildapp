package com.example.characterbuilderapp.core.mapper;

import com.example.characterbuilderapp.domain.build.CharacterBuiltVisionCard;
import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltVisionCardModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CharacterBuiltVisionCardMapper {

    public static final CharacterBuiltVisionCardMapper INSTANCE = Mappers.getMapper(CharacterBuiltVisionCardMapper.class);

    public abstract CharacterBuiltVisionCardModel mapToModel(CharacterBuiltVisionCard characterBuiltVisionCard);
}
