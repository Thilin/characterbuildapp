package com.example.characterbuilderapp.core.repository.impl;

import com.example.characterbuilderapp.core.exception.ErrorConstants;
import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.core.mapper.EquipmentMapper;
import com.example.characterbuilderapp.core.repository.EquipmentRepository;
import com.example.characterbuilderapp.domain.equipment.Equipment;
import com.example.characterbuilderapp.infra.db.msql.data.equipment.EquipmentModel;
import com.example.characterbuilderapp.infra.db.msql.repository.EquipmentRepositoryMysql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.*;
import static com.example.characterbuilderapp.core.mapper.EquipmentMapper.*;

@Repository
@AllArgsConstructor
public class EquipmentRepositoryImpl implements EquipmentRepository {

    private final EquipmentRepositoryMysql equipmentRepositoryMysql;
    @Override
    public Equipment findById(Long id) {
        EquipmentModel model = equipmentRepositoryMysql.findById(id).orElseThrow(() -> new ObjectNotFoundException(FORMATION_NAO_ENCONTRADO));
        return INSTANCE.mapToDomain(model);
    }
}
