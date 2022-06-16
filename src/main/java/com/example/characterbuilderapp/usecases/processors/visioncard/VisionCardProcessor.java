package com.example.characterbuilderapp.usecases.processors.visioncard;

import com.example.characterbuilderapp.core.operations.visioncard.VisionCardOperation;
import com.example.characterbuilderapp.core.repository.VisionCardRepository;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VisionCardProcessor implements Processor<VisionCardOperation, VisionCardOperation> {

    private final VisionCardRepository visionCardRepository;

    @Override
    public VisionCardOperation process(VisionCardOperation operation) {
        var visionCard = visionCardRepository.findById(operation.getVisionCard().getId());
        operation.setVisionCard(visionCard);
        return operation;
    }
}
