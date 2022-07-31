package com.example.characterbuilderapp.usecases.reaction.processors;

import com.example.characterbuilderapp.core.operations.reaction.ReactionOperation;
import com.example.characterbuilderapp.core.repository.ReactionRepository;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindReactionByIdProcessor implements Processor<ReactionOperation, ReactionOperation> {

    private final ReactionRepository reactionRepository;

    @Override
    public ReactionOperation process(ReactionOperation operation) {
        var reaction = reactionRepository.findById(operation.getReaction().getId());
        operation.setReaction(reaction);
        return operation;
    }
}
