package com.example.characterbuilderapp.infra.db.msql.repository;

import com.example.characterbuilderapp.infra.db.msql.data.job.JobModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepositoryMysql extends JpaRepository<JobModel, Long> {
    Page<JobModel> findByDescription(String description, Pageable pageable);

}
