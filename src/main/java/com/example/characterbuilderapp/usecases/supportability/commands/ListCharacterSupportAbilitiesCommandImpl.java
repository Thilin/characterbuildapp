package com.example.characterbuilderapp.usecases.supportability.commands;

import com.example.characterbuilderapp.core.business.supportability.ListCharacterSupportAbilitiesCommand;
import com.example.characterbuilderapp.core.operations.supportability.ListSupportAbilitiesByCharacterIdOperation;
import com.example.characterbuilderapp.usecases.supportability.processors.FindCharacterJobsProcessor;
import com.example.characterbuilderapp.usecases.supportability.processors.ListSupportAbilityByCharacterIdProcessor;
import com.example.characterbuilderapp.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListCharacterSupportAbilitiesCommandImpl implements ListCharacterSupportAbilitiesCommand {

    private final FindCharacterJobsProcessor findJobsByCharacterIdProcessor;
    private final ListSupportAbilityByCharacterIdProcessor listSupportAbilityByCharacterIdProcessor;

    @Override
    public ListSupportAbilitiesByCharacterIdOperation execute(ListSupportAbilitiesByCharacterIdOperation operation) {
        return Pipeline.given(operation)
                .process(findJobsByCharacterIdProcessor)
                .process(listSupportAbilityByCharacterIdProcessor)
                .getOutput();
    }
}
