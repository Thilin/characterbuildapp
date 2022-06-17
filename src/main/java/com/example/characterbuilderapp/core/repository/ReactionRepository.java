package com.example.characterbuilderapp.core.repository;

import com.example.characterbuilderapp.domain.reaction.Reaction;

public interface ReactionRepository {

    Reaction findById(Long id);
}
