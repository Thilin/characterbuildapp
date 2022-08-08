package com.example.characterbuilderapp.usecases.build.processors;

import com.example.characterbuilderapp.core.operations.build.CreateBuildOperation;
import com.example.characterbuilderapp.core.repository.CharacterBuildEquipmentRepository;
import com.example.characterbuilderapp.core.repository.EquipmentRepository;
import com.example.characterbuilderapp.domain.build.CharacterBuildEquipment;
import com.example.characterbuilderapp.domain.equipment.Equipment;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@AllArgsConstructor
public class CreateBuildEquipmentsProcessor implements Processor<CreateBuildOperation, CreateBuildOperation> {

    private final EquipmentRepository equipmentRepository;
    private final CharacterBuildEquipmentRepository characterBuildEquipmentRepository;

    @Override
    @Transactional
    public CreateBuildOperation process(CreateBuildOperation createBuildOperation) {
        List<Long> equipmentsId = createBuildOperation.getEquipmentsId();
        equipmentsId.forEach(id ->{
            CharacterBuildEquipment characterBuildEquipment = new CharacterBuildEquipment();

            Equipment equipment = equipmentRepository.findById(id);
            characterBuildEquipment.setEquipment(equipment);
            characterBuildEquipment.setCharacterBuilt(createBuildOperation.getBuild());

            characterBuildEquipmentRepository.save(characterBuildEquipment);
        });
        return createBuildOperation;
    }
}
