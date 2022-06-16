package com.example.characterbuilderapp.infra.db.msql.repository;

import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterBuiltRepositoryMysql extends JpaRepository<CharacterBuiltModel, Long> {
    Page<CharacterBuiltModel> findByUserId(Long id, Pageable pageable);
    List<CharacterBuiltModel> findByUserId(Long id);
}
