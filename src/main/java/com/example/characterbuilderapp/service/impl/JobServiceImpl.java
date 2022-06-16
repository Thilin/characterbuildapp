package com.example.characterbuilderapp.service.impl;

import com.example.characterbuilderapp.infra.db.msql.data.job.JobModel;
import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.infra.db.msql.repository.JobRepositoryMysql;
import com.example.characterbuilderapp.service.CharacterJobService;
import com.example.characterbuilderapp.service.JobService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.*;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepositoryMysql jobRepository;
    private final CharacterJobService characterJobService;

    public JobServiceImpl(JobRepositoryMysql jobRepository, CharacterJobService characterJobService){
        this.jobRepository = jobRepository;
        this.characterJobService = characterJobService;
    }
    @Override
    public JobModel findById(Long id) {
        return jobRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException(JOB_NAO_ENCONTRADO));
    }

    @Override
    public Page<JobModel> pageAll(String description, Pageable pageable) {
        if(description != null)
            return jobRepository.findByDescription(description, pageable);
        else
            return jobRepository.findAll(pageable);
    }

    @Override
    public List<JobModel> findByCharacterId(Long id) {
        var characterJobs = characterJobService.findJobsByCharacterId(id);
        var jobs = new ArrayList<JobModel>();
        characterJobs.forEach(characterJob -> jobs.add(characterJob.getJob()));
        return jobs;
    }

}
