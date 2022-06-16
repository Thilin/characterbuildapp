package com.example.characterbuilderapp.infra.db.msql.repository;

import com.example.characterbuilderapp.infra.db.msql.data.equipment.EquipmentTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentTypeRepositoryMysql extends JpaRepository<EquipmentTypeModel, Long> {
}