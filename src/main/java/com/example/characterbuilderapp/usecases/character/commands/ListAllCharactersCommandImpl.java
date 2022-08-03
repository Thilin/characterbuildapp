package com.example.characterbuilderapp.usecases.character.commands;

import com.example.characterbuilderapp.core.business.character.ListAllCharactersCommand;
import com.example.characterbuilderapp.core.operations.character.ListAllCharactersOperation;
import com.example.characterbuilderapp.usecases.character.processors.ListAllCharactersProcessor;
import com.example.characterbuilderapp.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListAllCharactersCommandImpl implements ListAllCharactersCommand {

    private final ListAllCharactersProcessor listAllCharactersProcessor;
    @Override
    public ListAllCharactersOperation execute(ListAllCharactersOperation operation) {
        return Pipeline.given(operation)
                .process(listAllCharactersProcessor)
                .getOutput();
    }
}
