package com.example.characterbuilderapp.service;

import com.example.characterbuilderapp.infra.db.msql.data.character.CharacterJobModel;

import java.util.List;

public interface CharacterJobService {

    public List<CharacterJobModel> findJobsByCharacterId(Long id);
    public CharacterJobModel findByJobIdAndCharacterId(Long jobId, Long characterId);
}
