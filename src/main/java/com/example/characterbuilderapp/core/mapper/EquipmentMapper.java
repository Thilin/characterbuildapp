package com.example.characterbuilderapp.core.mapper;

import com.example.characterbuilderapp.domain.equipment.Equipment;
import com.example.characterbuilderapp.infra.db.msql.data.equipment.EquipmentModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class EquipmentMapper {

    public static final EquipmentMapper INSTANCE = Mappers.getMapper(EquipmentMapper.class);

    public abstract Equipment mapToDomain(EquipmentModel equipmentModel);
}
