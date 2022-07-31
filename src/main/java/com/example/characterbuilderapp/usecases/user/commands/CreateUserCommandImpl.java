package com.example.characterbuilderapp.usecases.user.commands;

import com.example.characterbuilderapp.core.business.user.CreateUserCommand;
import com.example.characterbuilderapp.core.operations.user.UserOperation;
import com.example.characterbuilderapp.usecases.user.processors.CreateUserProcessor;
import com.example.characterbuilderapp.usecases.user.processors.ValidateEmailProcessor;
import com.example.characterbuilderapp.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateUserCommandImpl implements CreateUserCommand {

    private final ValidateEmailProcessor validateEmailProcessor;
    private final CreateUserProcessor createUserProcessor;

    @Override
    public UserOperation execute(UserOperation operation) {
        return Pipeline
                .given(operation)
                .process(validateEmailProcessor)
                .process(createUserProcessor)
                .getOutput();

    }
}
