package com.example.characterbuilderapp.service;

import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltModel;
import com.example.characterbuilderapp.infra.db.msql.data.supportability.SupportAbilityModel;

import java.util.List;

public interface CharacterBuiltSupportAbilityService {

    public void saveSupportAbilitiesBuild(List<Long> supportAbilitiesId, CharacterBuiltModel characterBuilt);

    List<SupportAbilityModel> findByBuildId(Long id);
}
