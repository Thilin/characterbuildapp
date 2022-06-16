package com.example.characterbuilderapp.service.impl;

import com.example.characterbuilderapp.infra.db.msql.data.element.ElementModel;
import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.infra.db.msql.repository.ElementRepositoryMysql;
import com.example.characterbuilderapp.service.ElementService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.*;

@Service
public class ElementServiceImpl implements ElementService {

    private final ElementRepositoryMysql elementRepository;

    public ElementServiceImpl(ElementRepositoryMysql elementRepository){
        this.elementRepository = elementRepository;
    }

    @Override
    public ElementModel findById(Long id) {
        return elementRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException(ELEMENT_NAO_ENCONTRADO));
    }

    @Override
    public Page<ElementModel> pageAll(String description, Pageable pageable) {
        if(description != null)
            return elementRepository.findByDescription(description, pageable);
        else
            return elementRepository.findAll(pageable);
    }
}
