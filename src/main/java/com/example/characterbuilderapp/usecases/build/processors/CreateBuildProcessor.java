package com.example.characterbuilderapp.usecases.build.processors;

import com.example.characterbuilderapp.core.operations.build.CreateBuildOperation;
import com.example.characterbuilderapp.core.repository.CharacterBuildRepository;
import com.example.characterbuilderapp.domain.build.Build;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@AllArgsConstructor
public class CreateBuildProcessor implements Processor<CreateBuildOperation, CreateBuildOperation> {

    private final CharacterBuildRepository characterBuildRepository;
    
    @Override
    @Transactional
    public CreateBuildOperation process(CreateBuildOperation createBuildOperation) {
        var build = new Build();
        build.setName(createBuildOperation.getName());
        build.setUser(createBuildOperation.getUser());
        build.setCharacter(createBuildOperation.getCharacter());
        build.setEsper(createBuildOperation.getEsper());
        build.setReaction(createBuildOperation.getReaction());

        build = characterBuildRepository.save(build);
        createBuildOperation.setBuild(build);
        return createBuildOperation;
    }
}
