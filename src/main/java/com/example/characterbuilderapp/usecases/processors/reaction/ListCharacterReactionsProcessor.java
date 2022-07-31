package com.example.characterbuilderapp.usecases.processors.reaction;

import com.example.characterbuilderapp.core.operations.reaction.ListCharacterReactionsOperation;
import com.example.characterbuilderapp.core.repository.ReactionRepository;
import com.example.characterbuilderapp.domain.reaction.Reaction;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ListCharacterReactionsProcessor implements Processor<ListCharacterReactionsOperation, ListCharacterReactionsOperation> {

    private final ReactionRepository reactionRepository;
    @Override
    public ListCharacterReactionsOperation process(ListCharacterReactionsOperation operation) {
        var reactionsList = new ArrayList<Reaction>();
        operation.getJobs().forEach(job -> {
            Reaction reaction = reactionRepository.findByJobId(job.getId());
            reactionsList.add(reaction);
        });
        operation.setReactions(reactionsList);
        return operation;
    }
}
