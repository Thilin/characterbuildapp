package com.example.characterbuilderapp.service.impl;

import com.example.characterbuilderapp.infra.db.msql.data.character.CharacterJobModel;
import com.example.characterbuilderapp.infra.db.msql.repository.CharacterJobRepositoryMysql;
import com.example.characterbuilderapp.service.CharacterJobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterJobServiceImpl implements CharacterJobService {

    private final CharacterJobRepositoryMysql characterJobRepository;

    public CharacterJobServiceImpl(CharacterJobRepositoryMysql characterJobRepository){
        this.characterJobRepository = characterJobRepository;
    }
    @Override
    public List<CharacterJobModel> findJobsByCharacterId(Long id) {
        return characterJobRepository.findByCharacterId(id);
    }

    @Override
    public CharacterJobModel findByJobIdAndCharacterId(Long jobId, Long characterId) {
        return characterJobRepository.findByJobIdAndCharacterId(jobId, characterId);
    }
}
