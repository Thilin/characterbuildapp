package com.example.characterbuilderapp.usecases.user.processors;

import com.example.characterbuilderapp.core.operations.user.UserOperation;
import com.example.characterbuilderapp.core.repository.UserRepository;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateUserProcessor implements Processor<UserOperation, UserOperation> {

    private final UserRepository userRepository;
    @Override
    public UserOperation process(UserOperation operation) {
        operation.setUser(userRepository.createUser(operation.getUser()));
        return operation;
    }
}
