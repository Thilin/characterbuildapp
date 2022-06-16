package com.example.characterbuilderapp.service;

import com.example.characterbuilderapp.infra.db.msql.data.visioncard.VisionCardModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VisionCardService {

    public VisionCardModel findById(Long id);
    public Page<VisionCardModel> pageAll(String description, Pageable pageable);
}
