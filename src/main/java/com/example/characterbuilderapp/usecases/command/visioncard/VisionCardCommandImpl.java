package com.example.characterbuilderapp.usecases.command.visioncard;

import com.example.characterbuilderapp.core.business.visioncard.VisionCardCommand;
import com.example.characterbuilderapp.core.operations.visioncard.VisionCardOperation;
import com.example.characterbuilderapp.usecases.processors.visioncard.VisionCardProcessor;
import com.example.characterbuilderapp.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VisionCardCommandImpl implements VisionCardCommand {

    private final VisionCardProcessor visionCardProcessor;

    @Override
    public VisionCardOperation execute(VisionCardOperation operation) {
        return Pipeline
                .given(operation)
                .process(visionCardProcessor)
                .getOutput();
    }
}
