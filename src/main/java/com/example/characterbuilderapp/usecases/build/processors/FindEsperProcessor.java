package com.example.characterbuilderapp.usecases.build.processors;

import com.example.characterbuilderapp.core.operations.build.CreateBuildOperation;
import com.example.characterbuilderapp.core.repository.EsperRepository;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindEsperProcessor implements Processor<CreateBuildOperation, CreateBuildOperation> {

    private final EsperRepository esperRepository;

    @Override
    public CreateBuildOperation process(CreateBuildOperation createBuildOperation) {
        var esper = esperRepository.findById(createBuildOperation.getEsperId());
        createBuildOperation.setEsper(esper);
        return createBuildOperation;
    }
}
