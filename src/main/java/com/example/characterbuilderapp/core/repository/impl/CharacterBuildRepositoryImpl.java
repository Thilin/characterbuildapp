package com.example.characterbuilderapp.core.repository.impl;

import com.example.characterbuilderapp.core.repository.CharacterBuildRepository;
import com.example.characterbuilderapp.domain.build.Build;
import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltModel;
import com.example.characterbuilderapp.infra.db.msql.repository.CharacterBuiltRepositoryMysql;
import com.example.characterbuilderapp.mapper.BuildMapper;
import com.example.characterbuilderapp.mapper.CharacterMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class CharacterBuildRepositoryImpl implements CharacterBuildRepository {

    private final CharacterBuiltRepositoryMysql characterBuiltRepositoryMysql;
    @Override
    public void save(Build build) {
        CharacterBuiltModel model = BuildMapper.INSTANCE.mapToModel(build);
        characterBuiltRepositoryMysql.save(model);
    }

    @Override
    public List<Build> findByUserId(Long userId) {
        var builds = characterBuiltRepositoryMysql.findByUserId(userId);
        return builds.stream().map(BuildMapper.INSTANCE::mapToDomain).collect(Collectors.toList());
    }
}
