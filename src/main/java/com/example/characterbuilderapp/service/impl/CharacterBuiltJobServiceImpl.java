package com.example.characterbuilderapp.service.impl;

import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltModel;
import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltJobModel;
import com.example.characterbuilderapp.infra.db.msql.data.job.JobModel;
import com.example.characterbuilderapp.infra.db.msql.repository.CharacterBuiltJobRepositorMysql;
import com.example.characterbuilderapp.service.CharacterBuiltJobService;
import com.example.characterbuilderapp.service.CharacterJobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterBuiltJobServiceImpl implements CharacterBuiltJobService {

    private final CharacterBuiltJobRepositorMysql characterBuiltJobRepository;
    private final CharacterJobService characterJobService;

    public CharacterBuiltJobServiceImpl(CharacterBuiltJobRepositorMysql characterBuiltJobRepository,
                                        CharacterJobService characterJobService){
        this.characterBuiltJobRepository = characterBuiltJobRepository;
        this.characterJobService = characterJobService;
    }
    @Override
    public void saveBuildJobs(List<Long> jobsId, CharacterBuiltModel characterBuilt) {
        jobsId.forEach(id -> {
            var characterBuiltJob = new CharacterBuiltJobModel();
            var characterJob = characterJobService.findByJobIdAndCharacterId(id, characterBuilt.getCharacter().getId());
            characterBuiltJob.setCharacterBuilt(characterBuilt);
            characterBuiltJob.setCharacterJob(characterJob);
            characterBuiltJob.setMain(characterJob.isMain());
            characterBuiltJobRepository.save(characterBuiltJob);
        });
    }

    @Override
    public List<JobModel> findByBuildId(Long id) {
        var characterBuiltJobs = characterBuiltJobRepository.findByCharacterBuiltId(id);
        var jobs = new ArrayList<JobModel>();
        characterBuiltJobs.forEach(characterBuiltJob -> jobs.add(characterBuiltJob.getCharacterJob().getJob()));
        return jobs;
    }
}
