package com.example.characterbuilderapp.usecases.supportability.processors;


import com.example.characterbuilderapp.core.operations.supportability.ListSupportAbilitiesByCharacterIdOperation;
import com.example.characterbuilderapp.core.repository.CharacterJobRepository;
import com.example.characterbuilderapp.domain.job.Job;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FindCharacterJobsProcessor implements Processor<ListSupportAbilitiesByCharacterIdOperation, ListSupportAbilitiesByCharacterIdOperation> {

    private final CharacterJobRepository characterJobRepository;
    @Override
    public ListSupportAbilitiesByCharacterIdOperation process(ListSupportAbilitiesByCharacterIdOperation operation) {
        List<Job> jobs = characterJobRepository.findByCharacterId(operation.getCharacterId());
        operation.setJobs(jobs);
        return operation;
    }
}
