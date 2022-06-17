package com.example.characterbuilderapp.core.repository;

import com.example.characterbuilderapp.domain.esper.Esper;

public interface EsperRepository {

    Esper findById(Long id);
}
