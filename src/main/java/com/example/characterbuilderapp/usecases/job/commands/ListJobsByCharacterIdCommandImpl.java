package com.example.characterbuilderapp.usecases.job.commands;

import com.example.characterbuilderapp.core.business.job.ListJobsByCharacterIdCommand;
import com.example.characterbuilderapp.core.operations.job.ListCharacterJobsOperation;
import com.example.characterbuilderapp.usecases.job.processors.FindJobsByCharacterIdProcessor;
import com.example.characterbuilderapp.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListJobsByCharacterIdCommandImpl implements ListJobsByCharacterIdCommand {

    private final FindJobsByCharacterIdProcessor findJobsByCharacterIdProcessor;

    @Override
    public ListCharacterJobsOperation execute(ListCharacterJobsOperation operation) {
        return Pipeline.given(operation)
                .process(findJobsByCharacterIdProcessor)
                .getOutput();
    }
}
