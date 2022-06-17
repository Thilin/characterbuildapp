package com.example.characterbuilderapp.core.business.reaction;

import com.example.characterbuilderapp.core.operations.reaction.ReactionOperation;

public interface FindReactionByIdCommand {

    ReactionOperation execute(ReactionOperation operation);
}
