package com.example.characterbuilderapp.usecases.command.character;

import com.example.characterbuilderapp.core.business.character.ListJobsByCharacterIdCommand;
import com.example.characterbuilderapp.core.operations.character.ListCharacterJobsOperation;
import com.example.characterbuilderapp.usecases.processors.job.FindJobsByCharacterIdProcessor;
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
