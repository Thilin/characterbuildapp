package com.example.characterbuilderapp.usecases.build.processors;

import com.example.characterbuilderapp.core.operations.build.CreateBuildOperation;
import com.example.characterbuilderapp.core.repository.CharacterBuildJobRepository;
import com.example.characterbuilderapp.core.repository.CharacterJobRepository;
import com.example.characterbuilderapp.core.repository.JobRepository;
import com.example.characterbuilderapp.domain.build.CharacterBuildJob;
import com.example.characterbuilderapp.domain.character.CharacterJob;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@AllArgsConstructor
public class CreateBuildJobsProcessor implements Processor<CreateBuildOperation, CreateBuildOperation> {

    private final CharacterJobRepository characterJobRepository;
    private final JobRepository jobRepository;
    private final CharacterBuildJobRepository characterBuildJobRepository;

    @Override
    @Transactional
    public CreateBuildOperation process(CreateBuildOperation createBuildOperation) {
        var jobsId = createBuildOperation.getJobsId();
        jobsId.forEach(jobId ->{
            CharacterBuildJob characterBuildJob = new CharacterBuildJob();

            CharacterJob characterJob = characterJobRepository.findByJobIdAndCharacterId(jobId, createBuildOperation.getCharacter().getId());
            characterBuildJob.setCharacterBuilt(createBuildOperation.getBuild());
            characterBuildJob.setCharacterJob(characterJob);

            characterBuildJobRepository.save(characterBuildJob);

        });
        return createBuildOperation;
    }
}
