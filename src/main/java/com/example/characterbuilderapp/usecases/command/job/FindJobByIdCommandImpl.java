package com.example.characterbuilderapp.usecases.command.job;

import com.example.characterbuilderapp.core.business.job.FindJobByIdCommand;
import com.example.characterbuilderapp.core.operations.job.JobOperation;
import com.example.characterbuilderapp.usecases.processors.job.FindJobByIdProcessor;
import com.example.characterbuilderapp.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindJobByIdCommandImpl implements FindJobByIdCommand {

    private final FindJobByIdProcessor findJobByIdProcessor;

    @Override
    public JobOperation execute(JobOperation operation) {
        return Pipeline
                .given(operation)
                .process(findJobByIdProcessor)
                .getOutput();
    }
}
