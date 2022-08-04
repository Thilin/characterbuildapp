package com.example.characterbuilderapp.core.repository;

import com.example.characterbuilderapp.domain.esper.Esper;

import java.util.List;

public interface EsperRepository {

    Esper findById(Long id);

    List<Esper> findAll();
}
