package com.example.characterbuilderapp.infra.db.msql.repository;

import com.example.characterbuilderapp.infra.db.msql.data.element.ElementModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementRepositoryMysql extends JpaRepository<ElementModel, Long> {

    Page<ElementModel> findByDescription(String description, Pageable pageable);
}
