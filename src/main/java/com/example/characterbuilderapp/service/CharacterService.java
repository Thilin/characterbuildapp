package com.example.characterbuilderapp.service;

import com.example.characterbuilderapp.infra.db.msql.data.character.CharacterModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CharacterService {

    public CharacterModel findById(Long id);
    public Page<CharacterModel> pageAll(String name, Pageable pageable);
}
