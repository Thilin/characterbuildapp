package com.example.characterbuilderapp.usecases.command.reaction;

import com.example.characterbuilderapp.core.business.reaction.FindReactionByIdCommand;
import com.example.characterbuilderapp.core.operations.reaction.ReactionOperation;
import com.example.characterbuilderapp.usecases.processors.reaction.FindReactionByIdProcessor;
import com.example.characterbuilderapp.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindReactionByIdCommandImpl implements FindReactionByIdCommand {

    private final FindReactionByIdProcessor findReactionByIdProcessor;

    @Override
    public ReactionOperation execute(ReactionOperation operation) {
        return Pipeline.given(operation)
                .process(findReactionByIdProcessor)
                .getOutput();
    }
}
