package com.example.characterbuilderapp.core.repository;

import com.example.characterbuilderapp.domain.character.Character;

import java.util.List;

public interface CharacterRepository {

    Character findById(Long id);

    List<Character> findAll();
}
