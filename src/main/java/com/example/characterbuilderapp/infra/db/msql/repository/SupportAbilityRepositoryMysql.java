package com.example.characterbuilderapp.infra.db.msql.repository;

import com.example.characterbuilderapp.infra.db.msql.data.supportability.SupportAbilityModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupportAbilityRepositoryMysql extends JpaRepository<SupportAbilityModel, Long> {
    Page<SupportAbilityModel> findByDescription(String description, Pageable pageable);

    List<SupportAbilityModel> findByJobId(Long id);
}
