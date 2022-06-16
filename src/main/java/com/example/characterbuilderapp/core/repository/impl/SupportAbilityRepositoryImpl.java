package com.example.characterbuilderapp.core.repository.impl;

import com.example.characterbuilderapp.core.exception.ErrorConstants;
import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.core.repository.SupportAbilityRepository;
import com.example.characterbuilderapp.domain.supportability.SupportAbility;
import com.example.characterbuilderapp.infra.db.msql.repository.SupportAbilityRepositoryMysql;
import com.example.characterbuilderapp.mapper.SupportAbilityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.*;

@Repository
@AllArgsConstructor
public class SupportAbilityRepositoryImpl implements SupportAbilityRepository {

    private final SupportAbilityRepositoryMysql supportAbilityRepositoryMysql;

    @Override
    public SupportAbility findById(Long id) {
        var model = supportAbilityRepositoryMysql.findById(id).orElseThrow(() -> new ObjectNotFoundException(SUPPORT_ABILITY_NAO_ENCONTRADO));
        return SupportAbilityMapper.INSTANCE.mapToDomain(model);
    }
}
