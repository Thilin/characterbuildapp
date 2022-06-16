package com.example.characterbuilderapp.service.impl;

import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltModel;
import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltEquipmentModel;
import com.example.characterbuilderapp.infra.db.msql.data.equipment.EquipmentModel;
import com.example.characterbuilderapp.infra.db.msql.repository.CharacterBuiltEquipmentRepositoryMysql;
import com.example.characterbuilderapp.service.CharacterBuiltEquipmentService;
import com.example.characterbuilderapp.service.EquipmentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterBuiltEquipmentServiceImpl implements CharacterBuiltEquipmentService {

    private final CharacterBuiltEquipmentRepositoryMysql characterBuiltEquipmentRepository;
    private final EquipmentService equipmentService;

    public CharacterBuiltEquipmentServiceImpl(CharacterBuiltEquipmentRepositoryMysql characterBuiltEquipmentRepository,
                                              EquipmentService equipmentService){
        this.characterBuiltEquipmentRepository = characterBuiltEquipmentRepository;
        this.equipmentService = equipmentService;
    }
    @Override
    public void saveEquipmentsBuild(List<Long> equipmentsId, CharacterBuiltModel characterBuilt) {
        if(equipmentsId != null) {
            equipmentsId.forEach(equipmentId -> {
                var characterBuiltEquipment = new CharacterBuiltEquipmentModel();
                var equipment = equipmentService.findById(equipmentId);
                characterBuiltEquipment.setCharacterBuilt(characterBuilt);
                characterBuiltEquipment.setEquipment(equipment);
                characterBuiltEquipmentRepository.save(characterBuiltEquipment);
            });
        }
    }

    @Override
    public List<EquipmentModel> findByBuildId(Long id) {
        var characterBuiltEquipments = characterBuiltEquipmentRepository.findByCharacterBuiltId(id);
        var equipments = new ArrayList<EquipmentModel>();
        characterBuiltEquipments.forEach(characterBuiltEquipment -> equipments.add(characterBuiltEquipment.getEquipment()));
        return equipments;
    }
}
