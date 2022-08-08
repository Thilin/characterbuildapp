package com.example.characterbuilderapp.core.repository.impl;

import com.example.characterbuilderapp.core.repository.CharacterBuildEquipmentRepository;
import com.example.characterbuilderapp.domain.build.CharacterBuildEquipment;
import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltEquipmentModel;
import com.example.characterbuilderapp.infra.db.msql.repository.CharacterBuiltEquipmentRepositoryMysql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.characterbuilderapp.core.mapper.CharacterBuiltEquipmentMapper.INSTANCE;

@Repository
@AllArgsConstructor
public class CharacterBuildEquipmentRepositoryImpl implements CharacterBuildEquipmentRepository {

    private final CharacterBuiltEquipmentRepositoryMysql characterBuiltEquipmentRepositoryMysql;
    @Override
    public void save(CharacterBuildEquipment characterBuildEquipment) {
        CharacterBuiltEquipmentModel characterBuildEquipmentModel = INSTANCE.mapToModel(characterBuildEquipment);
        characterBuiltEquipmentRepositoryMysql.save(characterBuildEquipmentModel);
    }
}
