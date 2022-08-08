package com.example.characterbuilderapp.core.repository;

import com.example.characterbuilderapp.domain.equipment.Equipment;

public interface EquipmentRepository {
    Equipment findById(Long id);
}
