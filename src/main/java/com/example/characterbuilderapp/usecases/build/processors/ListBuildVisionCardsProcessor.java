package com.example.characterbuilderapp.usecases.build.processors;

import com.example.characterbuilderapp.core.operations.build.ListResumedBuildOperation;
import com.example.characterbuilderapp.core.repository.CharacterBuildVisionCardRepository;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ListBuildVisionCardsProcessor implements Processor<ListResumedBuildOperation, ListResumedBuildOperation> {

    private final CharacterBuildVisionCardRepository characterBuildVisionCardRepository;

    @Override
    public ListResumedBuildOperation process(ListResumedBuildOperation operation) {
        return null;
    }
}
