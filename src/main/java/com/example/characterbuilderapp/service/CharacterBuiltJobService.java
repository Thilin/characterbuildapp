package com.example.characterbuilderapp.service;

import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltModel;
import com.example.characterbuilderapp.infra.db.msql.data.job.JobModel;

import java.util.List;

public interface CharacterBuiltJobService {

    public void saveBuildJobs(List<Long> jobsId, CharacterBuiltModel characterBuilt);

    List<JobModel> findByBuildId(Long id);
}
