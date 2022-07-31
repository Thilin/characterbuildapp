package com.example.characterbuilderapp.usecases.build.processors;

import com.example.characterbuilderapp.core.repository.CharacterBuildRepository;
import com.example.characterbuilderapp.domain.build.Build;
import com.example.characterbuilderapp.dto.ListBuildByUserIdOperation;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ListBuildByUserIdProcessor implements Processor<ListBuildByUserIdOperation, ListBuildByUserIdOperation> {

    private final CharacterBuildRepository characterBuildRepository;
    @Override
    public ListBuildByUserIdOperation process(ListBuildByUserIdOperation operation) {
        List<Build> builds = characterBuildRepository.findByUserId(operation.getUserId());
        operation.setBuild(builds);
        return operation;
    }
}
