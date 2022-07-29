package com.example.characterbuilderapp.core.repository;

import com.example.characterbuilderapp.domain.job.Job;

import java.util.List;

public interface CharacterJobRepository {

    List<Job> findByCharacterId(Long id);
}
