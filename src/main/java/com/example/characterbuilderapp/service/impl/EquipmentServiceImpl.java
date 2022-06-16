package com.example.characterbuilderapp.service.impl;

import com.example.characterbuilderapp.infra.db.msql.data.equipment.EquipmentModel;
import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.infra.db.msql.repository.EquipmentRepositoryMysql;
import com.example.characterbuilderapp.service.EquipmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.*;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepositoryMysql equipmentRepository;

    public EquipmentServiceImpl(EquipmentRepositoryMysql equipmentRepository){
        this.equipmentRepository = equipmentRepository;
    }
    @Override
    public EquipmentModel findById(Long id) {
        return equipmentRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(EQUIPMENT_NAO_ENCONTRADO));
    }

    @Override
    public Page<EquipmentModel> pageAll(String name, Pageable pageable) {
        return null;
    }
}
