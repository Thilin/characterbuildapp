package com.example.characterbuilderapp.usecases.processors.user;

import com.example.characterbuilderapp.core.exception.EmailAlreadyExistsException;
import com.example.characterbuilderapp.core.operations.user.UserOperation;
import com.example.characterbuilderapp.core.repository.UserRepository;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.*;

@Component
@AllArgsConstructor
public class ValidateEmailProcessor implements Processor<UserOperation, UserOperation> {

    private final UserRepository userRepository;

    @Override
    public UserOperation process(UserOperation operation) {
        if(userRepository.emailExists(operation.getUser().getEmail()))
            throw new EmailAlreadyExistsException(EMAIL_JA_CADASTRADO);
        else
            return operation;
    }
}
