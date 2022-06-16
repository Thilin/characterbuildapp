package com.example.characterbuilderapp.service.impl;

import com.example.characterbuilderapp.infra.db.msql.data.esper.EsperModel;
import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.infra.db.msql.repository.EsperRepositoryMysql;
import com.example.characterbuilderapp.service.EsperService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.*;

@Service
public class EsperServiceImpl implements EsperService {

    private final EsperRepositoryMysql esperRepository;

    public EsperServiceImpl(EsperRepositoryMysql esperRepository){
        this.esperRepository = esperRepository;
    }
    @Override
    public EsperModel findById(Long id) {
        return esperRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException(ESPER_NAO_ENCONTRADO));
    }

    @Override
    public Page<EsperModel> pageAll(String name, Pageable pageable) {
        if(name != null)
            return esperRepository.findByName(name, pageable);
        else
            return esperRepository.findAll(pageable);
    }
}
