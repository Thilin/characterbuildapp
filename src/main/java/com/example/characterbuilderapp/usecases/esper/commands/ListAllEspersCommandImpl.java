package com.example.characterbuilderapp.usecases.esper.commands;

import com.example.characterbuilderapp.core.business.esper.ListAllEspersCommand;
import com.example.characterbuilderapp.core.operations.esper.ListAllEspersOperation;
import com.example.characterbuilderapp.usecases.esper.processors.ListAllEspersProcessor;
import com.example.characterbuilderapp.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListAllEspersCommandImpl implements ListAllEspersCommand {

     private final ListAllEspersProcessor listAllEspersProcessor;

    @Override
    public ListAllEspersOperation execute(ListAllEspersOperation operation) {
        return Pipeline.given(operation)
                .process(listAllEspersProcessor)
                .getOutput();
    }
}
