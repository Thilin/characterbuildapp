package com.example.characterbuilderapp.usecases.processors.esper;

import com.example.characterbuilderapp.core.operations.esper.EsperOperation;
import com.example.characterbuilderapp.core.repository.EsperRepository;
import com.example.characterbuilderapp.domain.esper.Esper;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindEsperByIdProcessor implements Processor<EsperOperation, EsperOperation> {

    private EsperRepository esperRepository;
    @Override
    public EsperOperation process(EsperOperation esperOperation) {
        Esper esper = esperRepository.findById(esperOperation.getEsper().getId());
        esperOperation.setEsper(esper);
        return esperOperation;
    }
}
