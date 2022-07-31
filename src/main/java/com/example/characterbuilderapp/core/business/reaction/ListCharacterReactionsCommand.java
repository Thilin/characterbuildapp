package com.example.characterbuilderapp.core.business.reaction;

import com.example.characterbuilderapp.core.operations.reaction.ListCharacterReactionsOperation;

public interface ListCharacterReactionsCommand {

    ListCharacterReactionsOperation execute(ListCharacterReactionsOperation operation);
}
