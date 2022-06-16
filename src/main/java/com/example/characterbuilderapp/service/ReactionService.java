package com.example.characterbuilderapp.service;

import com.example.characterbuilderapp.infra.db.msql.data.reaction.ReactionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReactionService {

    public ReactionModel findById(Long id);
    public Page<ReactionModel> pageAll(String description, Pageable pageable);

    public ReactionModel findByJobId(Long id);

    List<ReactionModel> findByCharacterId(Long id);
}
