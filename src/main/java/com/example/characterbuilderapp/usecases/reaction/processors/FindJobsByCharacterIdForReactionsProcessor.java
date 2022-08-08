package com.example.characterbuilderapp.usecases.reaction.processors;

import com.example.characterbuilderapp.core.operations.reaction.ListCharacterReactionsOperation;
import com.example.characterbuilderapp.core.repository.CharacterJobRepository;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindJobsByCharacterIdForReactionsProcessor implements Processor<ListCharacterReactionsOperation, ListCharacterReactionsOperation> {

    private final CharacterJobRepository characterJobRepository;

    @Override
    public ListCharacterReactionsOperation process(ListCharacterReactionsOperation operation) {
        var jobs = characterJobRepository.findByCharacterId(operation.getCharacterId());
        operation.setJobs(jobs);
        return operation;
    }
}
