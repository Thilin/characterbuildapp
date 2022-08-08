package com.example.characterbuilderapp.core.repository.impl;

import com.example.characterbuilderapp.core.repository.CharacterBuildJobRepository;
import com.example.characterbuilderapp.domain.build.CharacterBuildJob;
import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltJobModel;
import com.example.characterbuilderapp.infra.db.msql.repository.CharacterBuiltJobRepositorMysql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.characterbuilderapp.core.mapper.CharacterBuiltJobMapper.INSTANCE;

@Repository
@AllArgsConstructor
public class CharacterBuildJobRepositoryImpl implements CharacterBuildJobRepository {

    private final CharacterBuiltJobRepositorMysql characterBuiltJobRepositorMysql;

    @Override
    public void save(CharacterBuildJob characterBuildJob) {
        CharacterBuiltJobModel model = INSTANCE.mapToModel(characterBuildJob);
        characterBuiltJobRepositorMysql.save(model);
    }
}
