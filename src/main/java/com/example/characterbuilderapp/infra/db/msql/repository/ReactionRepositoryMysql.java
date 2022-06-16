package com.example.characterbuilderapp.infra.db.msql.repository;

import com.example.characterbuilderapp.infra.db.msql.data.reaction.ReactionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionRepositoryMysql extends JpaRepository<ReactionModel, Long> {
    Page<ReactionModel> findByDescription(String description, Pageable pageable);
    ReactionModel findByJobId(Long id);

}
