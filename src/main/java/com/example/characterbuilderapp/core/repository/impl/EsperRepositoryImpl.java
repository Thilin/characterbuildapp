package com.example.characterbuilderapp.core.repository.impl;

import com.example.characterbuilderapp.core.exception.ErrorConstants;
import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.core.repository.EsperRepository;
import com.example.characterbuilderapp.domain.esper.Esper;
import com.example.characterbuilderapp.infra.db.msql.repository.EsperRepositoryMysql;
import com.example.characterbuilderapp.mapper.EsperMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.*;
import static com.example.characterbuilderapp.mapper.EsperMapper.*;

@Repository
@AllArgsConstructor
public class EsperRepositoryImpl implements EsperRepository {

    private final EsperRepositoryMysql esperRepositoryMysql;

    @Override
    public Esper findById(Long id) {
        var model = esperRepositoryMysql.findById(id).orElseThrow(() -> new ObjectNotFoundException(ESPER_NAO_ENCONTRADO));
        return INSTANCE.mapToDomain(model);
    }
}
