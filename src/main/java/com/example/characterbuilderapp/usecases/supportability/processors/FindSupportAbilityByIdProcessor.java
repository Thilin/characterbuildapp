package com.example.characterbuilderapp.usecases.supportability.processors;

import com.example.characterbuilderapp.core.operations.supportability.SupportAbilityOperation;
import com.example.characterbuilderapp.core.repository.SupportAbilityRepository;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindSupportAbilityByIdProcessor implements Processor<SupportAbilityOperation, SupportAbilityOperation> {

    private final SupportAbilityRepository supportAbilityRepository;

    @Override
    public SupportAbilityOperation process(SupportAbilityOperation operation) {
        var supportAbility = supportAbilityRepository.findById(operation.getSupportAbility().getId());
        operation.setSupportAbility(supportAbility);
        return operation;
    }
}
