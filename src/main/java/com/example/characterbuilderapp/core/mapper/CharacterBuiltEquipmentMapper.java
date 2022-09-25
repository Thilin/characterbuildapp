package com.example.characterbuilderapp.core.mapper;

import com.example.characterbuilderapp.domain.build.Build;
import com.example.characterbuilderapp.domain.build.CharacterBuildEquipment;
import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltEquipmentModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CharacterBuiltEquipmentMapper {

    public static final CharacterBuiltEquipmentMapper INSTANCE = Mappers.getMapper(CharacterBuiltEquipmentMapper.class);

    public abstract CharacterBuiltEquipmentModel mapToModel(CharacterBuildEquipment domain);

    public abstract CharacterBuildEquipment mapToDomain(CharacterBuiltEquipmentModel model);
}
