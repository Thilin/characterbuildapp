package com.example.characterbuilderapp.usecases.character.processors;

import com.example.characterbuilderapp.core.operations.character.ListAllCharactersOperation;
import com.example.characterbuilderapp.core.repository.CharacterRepository;
import com.example.characterbuilderapp.domain.character.Character;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ListAllCharactersProcessor implements Processor<ListAllCharactersOperation, ListAllCharactersOperation> {

    private final CharacterRepository characterRepository;

    @Override
    public ListAllCharactersOperation process(ListAllCharactersOperation operation) {
        List<Character> characters = characterRepository.findAll();
        operation.setCharacters(characters);
        return operation;
    }
}
