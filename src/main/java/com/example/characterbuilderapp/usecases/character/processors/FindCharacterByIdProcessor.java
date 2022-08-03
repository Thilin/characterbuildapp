package com.example.characterbuilderapp.usecases.character.processors;

import com.example.characterbuilderapp.core.operations.character.FindCharacterDetailsOperation;
import com.example.characterbuilderapp.core.repository.CharacterRepository;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class FindCharacterByIdProcessor implements Processor<FindCharacterDetailsOperation, FindCharacterDetailsOperation> {

    private final CharacterRepository characterRepository;

    @Override
    public FindCharacterDetailsOperation process(FindCharacterDetailsOperation operation) {
        var character = characterRepository.findById(operation.getId());
        operation.setCharacter(character);
        return operation;
    }
}
