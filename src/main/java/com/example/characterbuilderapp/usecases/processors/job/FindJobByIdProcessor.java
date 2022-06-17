package com.example.characterbuilderapp.usecases.processors.job;

import com.example.characterbuilderapp.core.operations.job.JobOperation;
import com.example.characterbuilderapp.core.repository.JobRepository;
import com.example.characterbuilderapp.domain.job.Job;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindJobByIdProcessor implements Processor<JobOperation, JobOperation> {

    private JobRepository jobRepository;
    @Override
    public JobOperation process(JobOperation jobOperation) {
        Job job = jobRepository.findById(jobOperation.getJob().getId());
        jobOperation.setJob(job);
        return jobOperation;
    }
}
