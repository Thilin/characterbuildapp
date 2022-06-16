package com.example.characterbuilderapp.infra.db.msql.repository;

import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltSupportAbilityModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterBuiltSupportAbilityRepositoryMysql extends JpaRepository<CharacterBuiltSupportAbilityModel, Long> {
    List<CharacterBuiltSupportAbilityModel> findByCharacterBuiltId(Long id);
}