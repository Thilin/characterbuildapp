package com.example.characterbuilderapp.core.repository;

import com.example.characterbuilderapp.domain.build.CharacterBuildJob;

public interface CharacterBuildJobRepository {
    void save(CharacterBuildJob characterBuildJob);
}
