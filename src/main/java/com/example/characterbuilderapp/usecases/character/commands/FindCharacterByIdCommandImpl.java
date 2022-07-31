package com.example.characterbuilderapp.usecases.character.commands;

import com.example.characterbuilderapp.core.business.character.FindCharacterByIdCommand;
import com.example.characterbuilderapp.core.operations.character.CharacterOperation;
import com.example.characterbuilderapp.usecases.character.processors.FindCharacterByIdProcessor;
import com.example.characterbuilderapp.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindCharacterByIdCommandImpl implements FindCharacterByIdCommand {

    private FindCharacterByIdProcessor findCharacterByIdProcessor;

    @Override
    public CharacterOperation execute(CharacterOperation operation) {
        return Pipeline.given(operation)
                .process(findCharacterByIdProcessor)
                .getOutput();
    }
}
