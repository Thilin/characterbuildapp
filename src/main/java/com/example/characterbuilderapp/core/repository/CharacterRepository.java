package com.example.characterbuilderapp.core.repository;

import com.example.characterbuilderapp.domain.character.Character;

public interface CharacterRepository {

    Character findById(Long id);
}
