package com.example.characterbuilderapp.usecases.build.processors;

import com.example.characterbuilderapp.core.operations.build.ListResumedBuildOperation;
import com.example.characterbuilderapp.core.repository.CharacterBuildEquipmentRepository;
import com.example.characterbuilderapp.core.repository.CharacterBuildRepository;
import com.example.characterbuilderapp.domain.build.Build;
import com.example.characterbuilderapp.domain.build.CharacterBuildEquipment;
import com.example.characterbuilderapp.domain.equipment.Equipment;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class FindBuildsByUserIdProcessor implements Processor<ListResumedBuildOperation, ListResumedBuildOperation> {

    private final CharacterBuildRepository characterBuildRepository;

    @Override
    public ListResumedBuildOperation process(ListResumedBuildOperation operation) {
        List<Build> builds = characterBuildRepository.findByUserId(operation.getUserId());
        operation.setBuilds(builds);

        return operation;
    }


}
