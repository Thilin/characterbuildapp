package com.example.characterbuilderapp.usecases.processors.build;

import com.example.characterbuilderapp.core.operations.build.CreateBuildOperation;
import com.example.characterbuilderapp.core.repository.UserRepository;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindUserProcessor implements Processor<CreateBuildOperation, CreateBuildOperation> {

    public final UserRepository userRepository;

    @Override
    public CreateBuildOperation process(CreateBuildOperation createBuildOperation) {
        var user = userRepository.findById(createBuildOperation.getUserId());
        createBuildOperation.setUser(user);
        return createBuildOperation;
    }
}
