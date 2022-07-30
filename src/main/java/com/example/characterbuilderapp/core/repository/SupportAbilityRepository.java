package com.example.characterbuilderapp.core.repository;

import com.example.characterbuilderapp.domain.supportability.SupportAbility;

import java.util.List;

public interface SupportAbilityRepository {

    SupportAbility findById(Long id);

    List<SupportAbility> findByJobId(Long id);
}
