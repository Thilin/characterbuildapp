package com.example.characterbuilderapp.infra.db.msql.repository;

import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltVisionCardModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterBuiltVisionCardRepositoryMysql extends JpaRepository<CharacterBuiltVisionCardModel, Long> {
    List<CharacterBuiltVisionCardModel> findByCharacterBuiltId(Long id);
}
