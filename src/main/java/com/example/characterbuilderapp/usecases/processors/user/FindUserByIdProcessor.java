package com.example.characterbuilderapp.usecases.processors.user;

import com.example.characterbuilderapp.core.operations.user.UserOperation;
import com.example.characterbuilderapp.core.repository.UserRepository;
import com.example.characterbuilderapp.domain.user.User;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindUserByIdProcessor implements Processor<UserOperation, UserOperation> {

    private final UserRepository userRepository;

    @Override
    public UserOperation process(UserOperation userOperation) {
        User user = userRepository.findById(userOperation.getUser().getId());
        userOperation.setUser(user);
        return userOperation;
    }
}
