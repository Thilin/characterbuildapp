package com.example.characterbuilderapp.core.repository;

import com.example.characterbuilderapp.domain.build.CharacterBuildEquipment;

import java.util.List;

public interface CharacterBuildEquipmentRepository {
    void save(CharacterBuildEquipment characterBuildEquipment);

    List<CharacterBuildEquipment> findByBuildId(Long id);
}
