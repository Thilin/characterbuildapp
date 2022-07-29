package com.example.characterbuilderapp.usecases.processors.build;

import com.example.characterbuilderapp.core.operations.build.CreateBuildOperation;
import com.example.characterbuilderapp.core.repository.CharacterRepository;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindCharacterProcessor implements Processor<CreateBuildOperation, CreateBuildOperation> {

    private final CharacterRepository characterRepository;

    @Override
    public CreateBuildOperation process(CreateBuildOperation createBuildOperation) {
        var character = characterRepository.findById(createBuildOperation.getCharacterId());
        createBuildOperation.setCharacter(character);
        return createBuildOperation;
    }
}
