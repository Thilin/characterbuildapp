package com.example.characterbuilderapp.usecases.command.visioncard;

import com.example.characterbuilderapp.core.business.visioncard.ListVisionCardsCommand;
import com.example.characterbuilderapp.core.operations.visioncard.ListVisionCardsOperation;
import com.example.characterbuilderapp.usecases.processors.visioncard.ListVisionCardsProcessor;
import com.example.characterbuilderapp.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListVisionCardsCommandImpl implements ListVisionCardsCommand {

    ListVisionCardsProcessor listVisionCardsProcessor;

    @Override
    public ListVisionCardsOperation execute(ListVisionCardsOperation operation) {
        return Pipeline.given(operation)
                .process(listVisionCardsProcessor)
                .getOutput();
    }
}
