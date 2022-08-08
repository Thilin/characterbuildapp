package com.example.characterbuilderapp.core.repository.impl;

import com.example.characterbuilderapp.core.mapper.CharacterBuiltSupportAbilityMapper;
import com.example.characterbuilderapp.core.repository.CharacterBuildSupportAbilityRepository;
import com.example.characterbuilderapp.domain.build.CharacterBuildSupportAbility;
import com.example.characterbuilderapp.infra.db.msql.repository.CharacterBuiltSupportAbilityRepositoryMysql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.characterbuilderapp.core.mapper.CharacterBuiltSupportAbilityMapper.*;

@Repository
@AllArgsConstructor
public class CharacterBuildSupportAbilityRepositoryImpl implements CharacterBuildSupportAbilityRepository {

    private final CharacterBuiltSupportAbilityRepositoryMysql characterBuiltSupportAbilityRepositoryMysql;

    @Override
    public void save(CharacterBuildSupportAbility characterBuildSupportAbility) {
        var model = INSTANCE.mapToModel(characterBuildSupportAbility);

        characterBuiltSupportAbilityRepositoryMysql.save(model);
    }
}
