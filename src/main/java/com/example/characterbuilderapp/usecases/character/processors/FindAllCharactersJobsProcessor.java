package com.example.characterbuilderapp.usecases.character.processors;

import com.example.characterbuilderapp.core.operations.character.FindCharacterDetailsOperation;
import com.example.characterbuilderapp.core.repository.CharacterJobRepository;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindAllCharactersJobsProcessor implements Processor<FindCharacterDetailsOperation, FindCharacterDetailsOperation> {

    private final CharacterJobRepository characterJobRepository;
    @Override
    public FindCharacterDetailsOperation process(FindCharacterDetailsOperation findCharacterDetailsOperation) {
        var jobs = characterJobRepository.findByCharacterId(findCharacterDetailsOperation.getCharacter().getId());
        findCharacterDetailsOperation.setJobs(jobs);
        return findCharacterDetailsOperation;
    }
}
