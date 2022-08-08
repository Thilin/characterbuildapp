package com.example.characterbuilderapp.core.repository.impl;

import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.core.repository.JobRepository;
import com.example.characterbuilderapp.domain.character.CharacterJob;
import com.example.characterbuilderapp.domain.job.Job;
import com.example.characterbuilderapp.infra.db.msql.repository.JobRepositoryMysql;
import com.example.characterbuilderapp.core.mapper.JobMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.*;

@AllArgsConstructor
@Repository
public class JobRepositoryImpl implements JobRepository {

    private final JobRepositoryMysql jobRepositoryMysql;
    @Override
    public Job findById(Long id) {
        var model = jobRepositoryMysql.findById(id).orElseThrow(() -> new ObjectNotFoundException(JOB_NAO_ENCONTRADO));
        return JobMapper.INSTANCE.mapToDomain(model);
    }
}
