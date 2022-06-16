package com.example.characterbuilderapp.infra.db.msql.repository;

import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltJobModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterBuiltJobRepositorMysql extends JpaRepository<CharacterBuiltJobModel, Long> {
    List<CharacterBuiltJobModel> findByCharacterBuiltId(Long id);
}
