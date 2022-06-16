package com.example.characterbuilderapp.service;

import com.example.characterbuilderapp.infra.db.msql.data.job.JobModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JobService {

    public JobModel findById(Long id);
    public Page<JobModel> pageAll(String description, Pageable pageable);

    List<JobModel> findByCharacterId(Long id);
}
