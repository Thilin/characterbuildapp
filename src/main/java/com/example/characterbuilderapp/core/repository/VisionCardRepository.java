package com.example.characterbuilderapp.core.repository;

import com.example.characterbuilderapp.domain.visioncard.VisionCard;

import java.util.List;

public interface VisionCardRepository {

    VisionCard findById(Long id);

    List<VisionCard> findAll();
}
