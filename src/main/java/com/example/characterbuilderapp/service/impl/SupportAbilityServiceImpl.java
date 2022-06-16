package com.example.characterbuilderapp.service.impl;

import com.example.characterbuilderapp.infra.db.msql.data.supportability.SupportAbilityModel;
import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.infra.db.msql.repository.SupportAbilityRepositoryMysql;
import com.example.characterbuilderapp.service.JobService;
import com.example.characterbuilderapp.service.SupportAbilityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.*;

@Service
public class SupportAbilityServiceImpl implements SupportAbilityService {

    private final SupportAbilityRepositoryMysql supportAbilityRepository;
    private final JobService jobService;

    public SupportAbilityServiceImpl(SupportAbilityRepositoryMysql supportAbilityRepository, JobService jobService){
        this.supportAbilityRepository = supportAbilityRepository;
        this.jobService = jobService;
    }

    @Override
    public SupportAbilityModel findById(Long id) {
        return supportAbilityRepository.findById(id).orElseThrow((() -> new ObjectNotFoundException(SUPPORT_ABILITY_NAO_ENCONTRADO)));
    }

    @Override
    public Page<SupportAbilityModel> pageAll(String description, Pageable pageable) {
        if(description != null)
            return supportAbilityRepository.findByDescription(description, pageable);
        else
            return supportAbilityRepository.findAll(pageable);
    }

    @Override
    public List<SupportAbilityModel> findByCharacterId(Long id) {
        var jobs = jobService.findByCharacterId(id);
        var supportAbilities = new ArrayList<SupportAbilityModel>();
        jobs.forEach(job -> {
            var supportAbilitiesFound = supportAbilityRepository.findByJobId(job.getId());
            supportAbilities.addAll(supportAbilitiesFound);
        });
        return supportAbilities;
    }
}
