package com.example.characterbuilderapp.infra.db.msql.repository;

import com.example.characterbuilderapp.infra.db.msql.data.character.CharacterJobModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterJobRepositoryMysql extends JpaRepository<CharacterJobModel, Long> {
    List<CharacterJobModel> findByCharacterId(Long id);

    CharacterJobModel findByJobIdAndCharacterId(Long jobId, Long characterId);
}
