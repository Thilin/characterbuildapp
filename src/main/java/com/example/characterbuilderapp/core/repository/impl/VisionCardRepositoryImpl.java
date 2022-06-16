package com.example.characterbuilderapp.core.repository.impl;

import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.core.repository.VisionCardRepository;
import com.example.characterbuilderapp.domain.visioncard.VisionCard;
import com.example.characterbuilderapp.infra.db.msql.repository.VisionCardRepositoryMysql;
import com.example.characterbuilderapp.mapper.VisionCardMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.USER_NAO_ENCONTRADO;
import static com.example.characterbuilderapp.core.exception.ErrorConstants.VISION_CARD_NAO_ENCONTRADO;

@Repository
@AllArgsConstructor
public class VisionCardRepositoryImpl implements VisionCardRepository {

    private final VisionCardRepositoryMysql visionCardRepositoryMysql;

    @Override
    public VisionCard findById(Long id) {
        var model = visionCardRepositoryMysql.findById(id).orElseThrow(()-> new ObjectNotFoundException(VISION_CARD_NAO_ENCONTRADO));
        return VisionCardMapper.INSTANCE.mapToDomain(model);
    }
}
