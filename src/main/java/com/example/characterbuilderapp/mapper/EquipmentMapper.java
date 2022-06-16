package com.example.characterbuilderapp.mapper;

import com.example.characterbuilderapp.infra.db.msql.data.equipment.EquipmentModel;
import com.example.characterbuilderapp.dto.EquipmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class EquipmentMapper {

    public static final EquipmentMapper INSTANCE = Mappers.getMapper(EquipmentMapper.class);

    public abstract EquipmentResponse mapToDTO(EquipmentModel equipment);
}
