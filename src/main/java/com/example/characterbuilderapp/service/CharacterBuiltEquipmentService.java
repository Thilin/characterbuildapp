package com.example.characterbuilderapp.service;

import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltModel;
import com.example.characterbuilderapp.infra.db.msql.data.equipment.EquipmentModel;

import java.util.List;

public interface CharacterBuiltEquipmentService {

    public void saveEquipmentsBuild(List<Long> equipmentsId, CharacterBuiltModel characterBuilt);

    public List<EquipmentModel> findByBuildId(Long id);
}
