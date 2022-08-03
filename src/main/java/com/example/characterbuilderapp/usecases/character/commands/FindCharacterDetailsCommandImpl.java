package com.example.characterbuilderapp.usecases.character.commands;

import com.example.characterbuilderapp.core.business.character.FindCharacterDetailsCommand;
import com.example.characterbuilderapp.core.operations.character.FindCharacterDetailsOperation;
import com.example.characterbuilderapp.usecases.character.processors.FindAllCharactersJobsProcessor;
import com.example.characterbuilderapp.usecases.character.processors.FindAllCharactersReactionsProcessor;
import com.example.characterbuilderapp.usecases.character.processors.FindAllCharactersSupportAbilitiesProcessor;
import com.example.characterbuilderapp.usecases.character.processors.FindCharacterByIdProcessor;
import com.example.characterbuilderapp.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindCharacterDetailsCommandImpl implements FindCharacterDetailsCommand {

    private final FindCharacterByIdProcessor findCharacterByIdProcessor;
    private final FindAllCharactersJobsProcessor findAllCharactersJobsProcessor;
    private final FindAllCharactersReactionsProcessor findAllCharactersReactionsProcessor;
    private final FindAllCharactersSupportAbilitiesProcessor findAllCharactersSupportAbilitiesProcessor;

    @Override
    public FindCharacterDetailsOperation execute(FindCharacterDetailsOperation operation) {
        return Pipeline.given(operation)
                .process(findCharacterByIdProcessor)
                .process(findAllCharactersJobsProcessor)
                .process(findAllCharactersReactionsProcessor)
                .process(findAllCharactersSupportAbilitiesProcessor)
                .getOutput();
    }
}
