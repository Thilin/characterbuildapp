package com.example.characterbuilderapp.usecases.build.commands;

import com.example.characterbuilderapp.core.business.build.ListBuildByUserIdCommand;
import com.example.characterbuilderapp.dto.ListBuildByUserIdOperation;
import com.example.characterbuilderapp.usecases.build.processors.ListBuildByUserIdProcessor;
import com.example.characterbuilderapp.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ListBuildByUserIdCommandImpl implements ListBuildByUserIdCommand {

    private final ListBuildByUserIdProcessor listBuildByUserIdProcessor;

    @Override
    public ListBuildByUserIdOperation execute(ListBuildByUserIdOperation operation) {
        return Pipeline.given(operation)
                .process(listBuildByUserIdProcessor)
                .getOutput();
    }
}
