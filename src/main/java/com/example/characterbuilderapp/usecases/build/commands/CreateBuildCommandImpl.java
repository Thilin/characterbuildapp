package com.example.characterbuilderapp.usecases.build.commands;

import com.example.characterbuilderapp.core.business.build.CreateBuildCommand;
import com.example.characterbuilderapp.core.operations.build.CreateBuildOperation;
import com.example.characterbuilderapp.usecases.build.processors.*;
import com.example.characterbuilderapp.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class CreateBuildCommandImpl implements CreateBuildCommand {

    private final FindCharacterProcessor findCharacterProcessor;
    private final FindUserProcessor findUserProcessor;
    private final FindReactionProcessor findReactionProcessor;
    private final FindEsperProcessor findEsperProcessor;
    private final CreateBuildProcessor createBuildProcessor;

    @Override
    public CreateBuildOperation execute(CreateBuildOperation operation) {
        return Pipeline.given(operation)
                .process(findCharacterProcessor)
                .process(findUserProcessor)
                .process(findReactionProcessor)
                .process(findEsperProcessor)
                .process(createBuildProcessor)
                .getOutput();
    }
}
