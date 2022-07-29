package com.example.characterbuilderapp.core.repository;

import com.example.characterbuilderapp.domain.build.Build;

import java.util.List;

public interface CharacterBuildRepository {

    void save(Build build);

    List<Build> findByUserId(Long userId);
}
