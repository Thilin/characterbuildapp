package com.example.characterbuilderapp.infra.db.msql.repository;

import com.example.characterbuilderapp.infra.db.msql.data.visioncard.VisionCardModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisionCardRepositoryMysql extends JpaRepository<VisionCardModel, Long> {

    Page<VisionCardModel> findByDescription(String description, Pageable pageable);
}
