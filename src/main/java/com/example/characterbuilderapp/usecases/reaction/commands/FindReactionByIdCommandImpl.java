package com.example.characterbuilderapp.usecases.reaction.commands;

import com.example.characterbuilderapp.core.business.reaction.FindReactionByIdCommand;
import com.example.characterbuilderapp.core.operations.reaction.ReactionOperation;
import com.example.characterbuilderapp.usecases.reaction.processors.FindReactionByIdProcessor;
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
