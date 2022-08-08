package com.example.characterbuilderapp.core.repository.impl;

import com.example.characterbuilderapp.core.mapper.CharacterJobMapper;
import com.example.characterbuilderapp.core.repository.CharacterJobRepository;
import com.example.characterbuilderapp.domain.character.CharacterJob;
import com.example.characterbuilderapp.domain.job.Job;
import com.example.characterbuilderapp.infra.db.msql.data.character.CharacterJobModel;
import com.example.characterbuilderapp.infra.db.msql.repository.CharacterJobRepositoryMysql;
import com.example.characterbuilderapp.core.mapper.JobMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class CharacterJobRepositoryImpl implements CharacterJobRepository {

    private final CharacterJobRepositoryMysql characterJobRepositoryMysql;

    @Override
    public CharacterJob findByJobIdAndCharacterId(Long jobId, Long id) {
        CharacterJobModel characterJobModel = characterJobRepositoryMysql.findByJobIdAndCharacterId(jobId, id);
        return CharacterJobMapper.INSTANCE.mapToDomain(characterJobModel);
    }

    @Override
    public List<Job> findByCharacterId(Long id) {
        var characterJobs = characterJobRepositoryMysql.findByCharacterId(id);
        return characterJobs.stream().map(characterJobModel -> JobMapper.INSTANCE.mapToDomain(characterJobModel.getJob())).collect(Collectors.toList());
    }
}
