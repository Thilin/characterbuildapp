package com.example.characterbuilderapp.infra.db.msql.repository;

import com.example.characterbuilderapp.infra.db.msql.data.character.CharacterEquipmentCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterEquipmentCategoryRepositoryMysql extends JpaRepository<CharacterEquipmentCategoryModel, Long> {
}
