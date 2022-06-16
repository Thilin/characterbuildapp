package com.example.characterbuilderapp.service;

import com.example.characterbuilderapp.infra.db.msql.data.supportability.SupportAbilityModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SupportAbilityService {

    public SupportAbilityModel findById(Long id);
    public Page<SupportAbilityModel> pageAll(String description, Pageable pageable);
    List<SupportAbilityModel> findByCharacterId(Long id);
}
