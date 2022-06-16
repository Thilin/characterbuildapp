package com.example.characterbuilderapp.service.impl;

import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltModel;
import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltSupportAbilityModel;
import com.example.characterbuilderapp.infra.db.msql.data.supportability.SupportAbilityModel;
import com.example.characterbuilderapp.infra.db.msql.repository.CharacterBuiltSupportAbilityRepositoryMysql;
import com.example.characterbuilderapp.service.CharacterBuiltSupportAbilityService;
import com.example.characterbuilderapp.service.SupportAbilityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterBuiltSupportAbilityServiceImpl implements CharacterBuiltSupportAbilityService{

    private final CharacterBuiltSupportAbilityRepositoryMysql characterBuiltSupportAbilityRepository;
    private final SupportAbilityService supportAbilityService;

    public CharacterBuiltSupportAbilityServiceImpl(CharacterBuiltSupportAbilityRepositoryMysql characterBuiltSupportAbilityRepository,
                                                   SupportAbilityService supportAbilityService){
        this.characterBuiltSupportAbilityRepository = characterBuiltSupportAbilityRepository;
        this.supportAbilityService = supportAbilityService;
    }

    @Override
    public void saveSupportAbilitiesBuild(List<Long> supportAbilitiesId, CharacterBuiltModel characterBuilt) {
        if( supportAbilitiesId != null){
            supportAbilitiesId.forEach(supportAbilityId -> {
                var characterBuiltSupportAbility = new CharacterBuiltSupportAbilityModel();
                var supportAbility = supportAbilityService.findById(supportAbilityId);
                characterBuiltSupportAbility.setSupportAbility(supportAbility);
                characterBuiltSupportAbility.setCharacterBuilt(characterBuilt);

                characterBuiltSupportAbilityRepository.save(characterBuiltSupportAbility);
            });
        }
    }

    @Override
    public List<SupportAbilityModel> findByBuildId(Long id) {
        var characterBuiltSupportAbilities = characterBuiltSupportAbilityRepository.findByCharacterBuiltId(id);
        var supportAbilities = new ArrayList<SupportAbilityModel>();
        characterBuiltSupportAbilities.forEach(characterBuiltSupportAbility -> supportAbilities.add(characterBuiltSupportAbility.getSupportAbility()));
        return supportAbilities;
    }
}
