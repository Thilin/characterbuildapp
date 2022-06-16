package com.example.characterbuilderapp.service.impl;

import com.example.characterbuilderapp.infra.db.msql.data.reaction.ReactionModel;
import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.infra.db.msql.repository.ReactionRepositoryMysql;
import com.example.characterbuilderapp.service.JobService;
import com.example.characterbuilderapp.service.ReactionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.*;

@Service
public class ReactionServiceImpl implements ReactionService {

    private final ReactionRepositoryMysql reactionRepository;
    private final JobService jobService;

    public ReactionServiceImpl(ReactionRepositoryMysql reactionRepository,
                               JobService jobService){
        this.reactionRepository = reactionRepository;
        this.jobService = jobService;
    }

    @Override
    public ReactionModel findById(Long id) {
        if(id != null)
            return reactionRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException(REACTION_NAO_ENCONTRADO));
        else
            return null;
    }

    @Override
    public Page<ReactionModel> pageAll(String description, Pageable pageable) {

        if(description != null)
            return reactionRepository.findByDescription(description, pageable);
        else
            return reactionRepository.findAll(pageable);
    }

    @Override
    public ReactionModel findByJobId(Long id) {
        return reactionRepository.findByJobId(id);
    }

    @Override
    public List<ReactionModel> findByCharacterId(Long id) {
        var reactions = new ArrayList<ReactionModel>();
        var jobs = jobService.findByCharacterId(id);
        jobs.forEach(job -> {
            var reaction = reactionRepository.findByJobId(job.getId());
            reactions.add(reaction);
        });

        return reactions;
    }
}
