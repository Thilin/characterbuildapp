package com.example.characterbuilderapp.usecases.command.reaction;

import com.example.characterbuilderapp.core.business.reaction.ListCharacterReactionsCommand;
import com.example.characterbuilderapp.core.operations.reaction.ListCharacterReactionsOperation;
import com.example.characterbuilderapp.usecases.processors.reaction.FindJobsByCharacterIdForReactionsProcessor;
import com.example.characterbuilderapp.usecases.processors.reaction.ListCharacterReactionsProcessor;
import com.example.characterbuilderapp.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListCharacterReactionsCommandImpl implements ListCharacterReactionsCommand {

    private final FindJobsByCharacterIdForReactionsProcessor findJobsByCharacterIdForReactionsProcessor;
    private final ListCharacterReactionsProcessor listCharacterReactionsProcessor;

    @Override
    public ListCharacterReactionsOperation execute(ListCharacterReactionsOperation operation) {

        return Pipeline.given(operation)
                .process(findJobsByCharacterIdForReactionsProcessor)
                .process(listCharacterReactionsProcessor)
                .getOutput();
    }
}
