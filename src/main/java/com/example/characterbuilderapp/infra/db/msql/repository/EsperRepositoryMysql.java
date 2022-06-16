package com.example.characterbuilderapp.infra.db.msql.repository;
import com.example.characterbuilderapp.infra.db.msql.data.esper.EsperModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EsperRepositoryMysql extends JpaRepository<EsperModel, Long> {
    Page<EsperModel> findByName(String name, Pageable pageable);
}
