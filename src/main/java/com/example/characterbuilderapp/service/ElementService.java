package com.example.characterbuilderapp.service;

import com.example.characterbuilderapp.infra.db.msql.data.element.ElementModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ElementService {

    public ElementModel findById(Long id);
    public Page<ElementModel> pageAll(String name, Pageable pageable);
}
