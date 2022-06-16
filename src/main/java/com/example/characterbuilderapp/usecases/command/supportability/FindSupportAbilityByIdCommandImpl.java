package com.example.characterbuilderapp.usecases.command.supportability;

import com.example.characterbuilderapp.core.business.supportability.FindSupportAbilityByIdCommand;
import com.example.characterbuilderapp.core.operations.supportability.SupportAbilityOperation;
import com.example.characterbuilderapp.usecases.processors.supportability.FindSupportAbilityByIdProcessor;
import com.example.characterbuilderapp.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindSupportAbilityByIdCommandImpl implements FindSupportAbilityByIdCommand {

    FindSupportAbilityByIdProcessor findSupportAbilityByIdProcessor;

    @Override
    public SupportAbilityOperation execute(SupportAbilityOperation operation) {
        return Pipeline
                .given(operation)
                .process(findSupportAbilityByIdProcessor)
                .getOutput();
    }
}
