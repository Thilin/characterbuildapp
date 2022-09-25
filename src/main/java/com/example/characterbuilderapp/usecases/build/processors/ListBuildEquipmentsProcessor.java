package com.example.characterbuilderapp.usecases.build.processors;

import com.example.characterbuilderapp.core.operations.build.ListResumedBuildOperation;
import com.example.characterbuilderapp.core.repository.CharacterBuildEquipmentRepository;
import com.example.characterbuilderapp.domain.build.CharacterBuildEquipment;
import com.example.characterbuilderapp.domain.equipment.Equipment;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ListBuildEquipmentsProcessor implements Processor<ListResumedBuildOperation, ListResumedBuildOperation> {

    private final CharacterBuildEquipmentRepository characterBuildEquipmentRepository;

    @Override
    public ListResumedBuildOperation process(ListResumedBuildOperation operation) {
        operation.getBuilds().forEach(build -> {
            List<CharacterBuildEquipment> buildEquipments = characterBuildEquipmentRepository.findByBuildId(build.getId());
            List<Equipment> equipments = new ArrayList<>();
            buildEquipments.forEach(characterBuildEquipment -> {
                equipments.add(characterBuildEquipment.getEquipment());
            });
            operation.setEquipments(equipments);
        });

        return operation;
    }
}
