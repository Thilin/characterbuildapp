package com.example.characterbuilderapp.usecases.build.commands;

import com.example.characterbuilderapp.core.business.build.ListResumedBuildByUserIdCommand;
import com.example.characterbuilderapp.core.operations.build.ListResumedBuildsResponse;
import com.example.characterbuilderapp.usecases.build.processors.ListBuildByUserIdProcessor;
import com.example.characterbuilderapp.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ListBuildByUserIdCommandImpl implements ListResumedBuildByUserIdCommand {

    private final ListBuildByUserIdProcessor listBuildByUserIdProcessor;

    @Override
    public ListResumedBuildsResponse execute(ListResumedBuildsResponse operation) {
        return Pipeline.given(operation)
                .process(listBuildByUserIdProcessor)
                .getOutput();
    }
}
