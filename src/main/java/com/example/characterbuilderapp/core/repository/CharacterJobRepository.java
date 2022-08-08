package com.example.characterbuilderapp.core.repository;

import com.example.characterbuilderapp.domain.character.CharacterJob;
import com.example.characterbuilderapp.domain.job.Job;

import java.util.List;

public interface CharacterJobRepository {

    CharacterJob findByJobIdAndCharacterId(Long jobId, Long id);

    List<Job> findByCharacterId(Long id);
}
