package com.example.characterbuilderapp.core.repository.impl;

import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.core.repository.ReactionRepository;
import com.example.characterbuilderapp.domain.reaction.Reaction;
import com.example.characterbuilderapp.infra.db.msql.repository.ReactionRepositoryMysql;
import com.example.characterbuilderapp.core.mapper.ReactionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.*;

@Repository
@AllArgsConstructor
public class ReactionRepositoryImpl implements ReactionRepository {

    private final ReactionRepositoryMysql reactionRepositoryMysql;
    @Override
    public Reaction findById(Long id) {
        var model = reactionRepositoryMysql.findById(id).orElseThrow(() -> new ObjectNotFoundException(REACTION_NAO_ENCONTRADO));
        return ReactionMapper.INSTANCE.mapToDomain(model);
    }

    @Override
    public Reaction findByJobId(Long id) {
        var model = reactionRepositoryMysql.findByJobId(id);
        return ReactionMapper.INSTANCE.mapToDomain(model);
    }
}
