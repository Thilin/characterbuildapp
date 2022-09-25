package com.example.characterbuilderapp.core.repository.impl;

import com.example.characterbuilderapp.core.repository.CharacterBuildEquipmentRepository;
import com.example.characterbuilderapp.domain.build.CharacterBuildEquipment;
import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltEquipmentModel;
import com.example.characterbuilderapp.infra.db.msql.repository.CharacterBuiltEquipmentRepositoryMysql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<CharacterBuildEquipment> findByBuildId(Long id) {
        List<CharacterBuiltEquipmentModel> characterBuildEquipments = characterBuiltEquipmentRepositoryMysql.findByCharacterBuiltId(id);
        return characterBuildEquipments.stream().map(INSTANCE::mapToDomain).collect(Collectors.toList());
    }
}
