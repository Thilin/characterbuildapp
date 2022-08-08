package com.example.characterbuilderapp.core.repository.impl;

import com.example.characterbuilderapp.core.repository.CharacterBuildRepository;
import com.example.characterbuilderapp.domain.build.Build;
import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltModel;
import com.example.characterbuilderapp.infra.db.msql.repository.CharacterBuiltRepositoryMysql;
import com.example.characterbuilderapp.core.mapper.BuildMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.characterbuilderapp.core.mapper.BuildMapper.*;

@Repository
@AllArgsConstructor
public class CharacterBuildRepositoryImpl implements CharacterBuildRepository {

    private final CharacterBuiltRepositoryMysql characterBuiltRepositoryMysql;
    @Override
    public Build save(Build build) {
        CharacterBuiltModel model = INSTANCE.mapToModel(build);
        characterBuiltRepositoryMysql.save(model);
        return INSTANCE.mapToDomain(model);
    }

    @Override
    public List<Build> findByUserId(Long userId) {
        var builds = characterBuiltRepositoryMysql.findByUserId(userId);
        return builds.stream().map(INSTANCE::mapToDomain).collect(Collectors.toList());
    }
}
