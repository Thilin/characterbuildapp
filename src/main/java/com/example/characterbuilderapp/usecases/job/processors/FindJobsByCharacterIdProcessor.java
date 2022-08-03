package com.example.characterbuilderapp.usecases.job.processors;

import com.example.characterbuilderapp.core.operations.job.ListCharacterJobsOperation;
import com.example.characterbuilderapp.core.repository.CharacterJobRepository;
import com.example.characterbuilderapp.domain.job.Job;
import com.example.characterbuilderapp.core.mapper.JobMapper;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FindJobsByCharacterIdProcessor implements Processor<ListCharacterJobsOperation, ListCharacterJobsOperation> {

    private final CharacterJobRepository characterJobRepository;
    @Override
    public ListCharacterJobsOperation process(ListCharacterJobsOperation listCharacterJobsOperation) {
        List<Job> jobs = characterJobRepository.findByCharacterId(listCharacterJobsOperation.getCharacterId());
        listCharacterJobsOperation.setJobs(jobs.stream().map(JobMapper.INSTANCE::mapToOperation).collect(Collectors.toList()));
        return listCharacterJobsOperation;
    }
}
