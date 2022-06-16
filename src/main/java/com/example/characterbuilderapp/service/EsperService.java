package com.example.characterbuilderapp.service;

import com.example.characterbuilderapp.infra.db.msql.data.esper.EsperModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EsperService {

    public EsperModel findById(Long id);
    public Page<EsperModel> pageAll(String name, Pageable pageable);
}
