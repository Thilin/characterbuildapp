package com.example.characterbuilderapp.infra.db.msql.repository;

import com.example.characterbuilderapp.infra.db.msql.data.equipment.EquipmentCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentCategoryRepositoryMysql extends JpaRepository<EquipmentCategoryModel, Long> {
}
