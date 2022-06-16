package com.example.characterbuilderapp.service;

import com.example.characterbuilderapp.infra.db.msql.data.equipment.EquipmentModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EquipmentService {

    public EquipmentModel findById(Long id);
    public Page<EquipmentModel> pageAll(String name, Pageable pageable);
}
