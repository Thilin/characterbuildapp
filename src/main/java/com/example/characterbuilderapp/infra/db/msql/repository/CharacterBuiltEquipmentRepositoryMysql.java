package com.example.characterbuilderapp.infra.db.msql.repository;

import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltEquipmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterBuiltEquipmentRepositoryMysql extends JpaRepository<CharacterBuiltEquipmentModel, Long> {

    List<CharacterBuiltEquipmentModel> findByCharacterBuiltId(Long id);
}
