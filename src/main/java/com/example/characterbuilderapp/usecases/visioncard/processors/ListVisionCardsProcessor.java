package com.example.characterbuilderapp.usecases.visioncard.processors;

import com.example.characterbuilderapp.core.operations.visioncard.ListVisionCardsOperation;
import com.example.characterbuilderapp.core.repository.VisionCardRepository;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ListVisionCardsProcessor implements Processor<ListVisionCardsOperation, ListVisionCardsOperation> {

    private final VisionCardRepository visionCardRepository;

    @Override
    public ListVisionCardsOperation process(ListVisionCardsOperation operation) {
        var visionCards = visionCardRepository.findAll();
        operation.setVisionCards(visionCards);
        return operation;
    }
}
