package com.example.characterbuilderapp.usecases.esper.commands;

import com.example.characterbuilderapp.core.business.esper.FindEsperByIdCommand;
import com.example.characterbuilderapp.core.operations.esper.EsperOperation;
import com.example.characterbuilderapp.usecases.esper.processors.FindEsperByIdProcessor;
import com.example.characterbuilderapp.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class  FindEsperByIdCommandImpl implements FindEsperByIdCommand {

    private final FindEsperByIdProcessor findEsperByIdProcessor;
    @Override
    public EsperOperation execute(EsperOperation operation) {
        return Pipeline.given(operation)
                .process(findEsperByIdProcessor)
                .getOutput();
    }
}
