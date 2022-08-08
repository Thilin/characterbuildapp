package com.example.characterbuilderapp.usecases.build.processors;

import com.example.characterbuilderapp.core.repository.CharacterBuildRepository;
import com.example.characterbuilderapp.domain.build.Build;
import com.example.characterbuilderapp.core.operations.build.ListResumedBuildsResponse;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ListBuildByUserIdProcessor implements Processor<ListResumedBuildsResponse, ListResumedBuildsResponse> {

    private final CharacterBuildRepository characterBuildRepository;
    @Override
    public ListResumedBuildsResponse process(ListResumedBuildsResponse operation) {
//        List<Build> builds = characterBuildRepository.findByUserId(operation.getUserId());
//        operation.setBuild(builds);
//        return operation;
        return null;
    }
}
