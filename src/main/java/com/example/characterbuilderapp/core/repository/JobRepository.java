package com.example.characterbuilderapp.core.repository;

import com.example.characterbuilderapp.domain.job.Job;

public interface JobRepository {
    Job findById(Long id);
}
