package com.example.characterbuilderapp.usecases.command.user;

import com.example.characterbuilderapp.core.business.user.FindUserByIdCommand;
import com.example.characterbuilderapp.core.operations.user.UserOperation;
import com.example.characterbuilderapp.usecases.processors.user.FindUserProcessor;
import com.example.characterbuilderapp.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindUserByIdCommandImpl implements FindUserByIdCommand {

    private final FindUserProcessor findUserProcessor;

    @Override
    public UserOperation execute(UserOperation operation) {
        return Pipeline
                .given(operation)
                .process(findUserProcessor)
                .getOutput();
    }
}
