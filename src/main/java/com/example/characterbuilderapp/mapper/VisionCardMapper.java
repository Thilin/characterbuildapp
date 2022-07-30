package com.example.characterbuilderapp.mapper;

import com.example.characterbuilderapp.core.operations.visioncard.VisionCardOperation;
import com.example.characterbuilderapp.domain.visioncard.VisionCard;
import com.example.characterbuilderapp.infra.db.msql.data.visioncard.VisionCardModel;
import com.example.characterbuilderapp.dto.VisionCardResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class VisionCardMapper {

    public static final VisionCardMapper INSTANCE = Mappers.getMapper(VisionCardMapper.class);

    public abstract VisionCardResponse mapToDTO(VisionCardModel visionCard);

    public abstract VisionCard mapToDomain(VisionCardModel model);

    @Mapping(target = "visionCard.id", source = "id")
    public abstract VisionCardOperation mapToOperation(Long id) ;

    @Mapping(target = "id", source = "visionCard.id")
    @Mapping(target = "description", source = "visionCard.description")
    @Mapping(target = "image", source = "visionCard.image")
    public abstract VisionCardResponse mapToResponse(VisionCard visionCard);
}
