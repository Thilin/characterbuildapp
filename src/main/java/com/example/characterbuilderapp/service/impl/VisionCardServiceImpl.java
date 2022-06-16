package com.example.characterbuilderapp.service.impl;

import com.example.characterbuilderapp.infra.db.msql.data.visioncard.VisionCardModel;
import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.infra.db.msql.repository.VisionCardRepositoryMysql;
import com.example.characterbuilderapp.service.VisionCardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.*;

@Service
public class VisionCardServiceImpl implements VisionCardService {

    private final VisionCardRepositoryMysql visionCardRepository;

    public VisionCardServiceImpl(VisionCardRepositoryMysql visionCardRepository){
        this.visionCardRepository = visionCardRepository;
    }

    @Override
    public VisionCardModel findById(Long id) {
        return visionCardRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(VISION_CARD_NAO_ENCONTRADO));
    }

    @Override
    public Page<VisionCardModel> pageAll(String description, Pageable pageable) {
        if(description != null)
            return visionCardRepository.findByDescription(description, pageable);
        else
            return visionCardRepository.findAll(pageable);
    }
}
