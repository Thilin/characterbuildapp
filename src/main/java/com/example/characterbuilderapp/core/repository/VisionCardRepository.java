package com.example.characterbuilderapp.core.repository;

import com.example.characterbuilderapp.domain.visioncard.VisionCard;

public interface VisionCardRepository {

    VisionCard findById(Long id);
}
