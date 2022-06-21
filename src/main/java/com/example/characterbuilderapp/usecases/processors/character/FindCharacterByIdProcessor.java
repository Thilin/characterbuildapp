package com.example.characterbuilderapp.usecases.processors.character;

import com.example.characterbuilderapp.core.operations.character.CharacterOperation;
import com.example.characterbuilderapp.core.repository.CharacterRepository;
import com.example.characterbuilderapp.domain.character.Character;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class FindCharacterByIdProcessor implements Processor<CharacterOperation, CharacterOperation> {

    private final CharacterRepository characterRepository;

    @Override
    public CharacterOperation process(CharacterOperation operation) {
        var character = characterRepository.findById(operation.getCharacter().getId());
        operation.setCharacter(character);
        return operation;
    }
}
