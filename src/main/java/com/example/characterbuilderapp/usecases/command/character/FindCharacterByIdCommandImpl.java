package com.example.characterbuilderapp.usecases.command.character;

import com.example.characterbuilderapp.core.business.character.FindCharacterByIdCommand;
import com.example.characterbuilderapp.core.operations.character.CharacterOperation;
import com.example.characterbuilderapp.usecases.processors.character.FindCharacterByIdProcessor;
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
