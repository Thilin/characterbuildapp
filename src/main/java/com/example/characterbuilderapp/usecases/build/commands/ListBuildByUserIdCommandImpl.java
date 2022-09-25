package com.example.characterbuilderapp.usecases.build.commands;

import com.example.characterbuilderapp.core.business.build.ListResumedBuildByUserIdCommand;
import com.example.characterbuilderapp.core.operations.build.ListResumedBuildOperation;
import com.example.characterbuilderapp.usecases.build.processors.FindBuildsByUserIdProcessor;
import com.example.characterbuilderapp.usecases.build.processors.ListBuildEquipmentsProcessor;
import com.example.characterbuilderapp.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ListBuildByUserIdCommandImpl implements ListResumedBuildByUserIdCommand {

    private final FindBuildsByUserIdProcessor findBuildsByUserIdProcessor;
    private final ListBuildEquipmentsProcessor listBuildEquipmentsProcessor;

    @Override
    public ListResumedBuildOperation execute(ListResumedBuildOperation operation) {
        return Pipeline.given(operation)
                .process(findBuildsByUserIdProcessor)
                .process(listBuildEquipmentsProcessor)
                .getOutput();
    }
}
