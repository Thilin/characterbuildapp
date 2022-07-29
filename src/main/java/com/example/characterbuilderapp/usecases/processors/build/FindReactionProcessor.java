package com.example.characterbuilderapp.usecases.processors.build;

import com.example.characterbuilderapp.core.operations.build.CreateBuildOperation;
import com.example.characterbuilderapp.core.repository.ReactionRepository;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FindReactionProcessor implements Processor<CreateBuildOperation, CreateBuildOperation> {

    private final ReactionRepository reactionRepository;

    @Override
    public CreateBuildOperation process(CreateBuildOperation createBuildOperation) {
        var reaction = reactionRepository.findById(createBuildOperation.getReactionId());
        createBuildOperation.setReaction(reaction);
        return createBuildOperation;
    }
}
