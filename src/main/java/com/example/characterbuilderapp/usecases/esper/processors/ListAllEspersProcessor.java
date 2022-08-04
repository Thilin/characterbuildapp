package com.example.characterbuilderapp.usecases.esper.processors;

import com.example.characterbuilderapp.core.operations.esper.ListAllEspersOperation;
import com.example.characterbuilderapp.core.repository.EsperRepository;
import com.example.characterbuilderapp.domain.esper.Esper;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ListAllEspersProcessor implements Processor<ListAllEspersOperation, ListAllEspersOperation> {

    private final EsperRepository esperRepository;
    @Override
    public ListAllEspersOperation process(ListAllEspersOperation listAllEspersOperation) {
        List<Esper> espers = esperRepository.findAll();
        listAllEspersOperation.setEspers(espers);
        return listAllEspersOperation;
    }
}
