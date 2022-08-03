package com.example.characterbuilderapp.core.repository.impl;

import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.core.repository.SupportAbilityRepository;
import com.example.characterbuilderapp.domain.supportability.SupportAbility;
import com.example.characterbuilderapp.infra.db.msql.repository.SupportAbilityRepositoryMysql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.*;
import static com.example.characterbuilderapp.core.mapper.SupportAbilityMapper.*;

@Repository
@AllArgsConstructor
public class SupportAbilityRepositoryImpl implements SupportAbilityRepository {

    private final SupportAbilityRepositoryMysql supportAbilityRepositoryMysql;

    @Override
    public SupportAbility findById(Long id) {
        var model = supportAbilityRepositoryMysql.findById(id).orElseThrow(() -> new ObjectNotFoundException(SUPPORT_ABILITY_NAO_ENCONTRADO));
        return INSTANCE.mapToDomain(model);
    }

    @Override
    public List<SupportAbility> findByJobId(Long id) {
        var models = supportAbilityRepositoryMysql.findByJobId(id);
        return models.stream().map(INSTANCE::mapToDomain).collect(Collectors.toList());
    }
}
