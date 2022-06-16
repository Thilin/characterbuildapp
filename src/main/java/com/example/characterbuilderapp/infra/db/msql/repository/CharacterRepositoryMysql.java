package com.example.characterbuilderapp.infra.db.msql.repository;


import com.example.characterbuilderapp.infra.db.msql.data.character.CharacterModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepositoryMysql extends JpaRepository<CharacterModel, Long> {
    Page<CharacterModel> findByName(String name, Pageable pageable);
}
