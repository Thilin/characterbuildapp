package com.example.characterbuilderapp.core.repository.impl;

import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.core.repository.EsperRepository;
import com.example.characterbuilderapp.domain.esper.Esper;
import com.example.characterbuilderapp.infra.db.msql.repository.EsperRepositoryMysql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.*;
import static com.example.characterbuilderapp.core.mapper.EsperMapper.*;

@Repository
@AllArgsConstructor
public class EsperRepositoryImpl implements EsperRepository {

    private final EsperRepositoryMysql esperRepositoryMysql;

    @Override
    public Esper findById(Long id) {
        var model = esperRepositoryMysql.findById(id).orElseThrow(() -> new ObjectNotFoundException(ESPER_NAO_ENCONTRADO));
        return INSTANCE.mapToDomain(model);
    }

    @Override
    public List<Esper> findAll() {
        var models = esperRepositoryMysql.findAll();
        return models.stream().map(INSTANCE::mapToDomain).collect(Collectors.toList());
    }
}
