package com.example.characterbuilderapp.infra.db.msql.repository;

import com.example.characterbuilderapp.infra.db.msql.data.equipment.EquipmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepositoryMysql extends JpaRepository<EquipmentModel, Long> {
}
