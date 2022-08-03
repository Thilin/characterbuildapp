package com.example.characterbuilderapp.usecases.character.processors;

import com.example.characterbuilderapp.core.operations.character.FindCharacterDetailsOperation;
import com.example.characterbuilderapp.core.repository.ReactionRepository;
import com.example.characterbuilderapp.domain.job.Job;
import com.example.characterbuilderapp.domain.reaction.Reaction;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class FindAllCharactersReactionsProcessor implements Processor<FindCharacterDetailsOperation, FindCharacterDetailsOperation> {

    private final ReactionRepository reactionRepository;
    @Override
    public FindCharacterDetailsOperation process(FindCharacterDetailsOperation findCharacterDetailsOperation) {
        var reactions = new ArrayList<Reaction>();
        var jobs = findCharacterDetailsOperation.getJobs();
        jobs.forEach(job -> {
            var reaction = reactionRepository.findByJobId(job.getId());
            reactions.add(reaction);
        });
        findCharacterDetailsOperation.setReactions(reactions);
        return findCharacterDetailsOperation;
    }
}
