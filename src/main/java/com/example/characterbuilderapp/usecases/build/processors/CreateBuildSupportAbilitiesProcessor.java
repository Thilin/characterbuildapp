package com.example.characterbuilderapp.usecases.build.processors;

import com.example.characterbuilderapp.core.operations.build.CreateBuildOperation;
import com.example.characterbuilderapp.core.repository.CharacterBuildSupportAbilityRepository;
import com.example.characterbuilderapp.core.repository.SupportAbilityRepository;
import com.example.characterbuilderapp.domain.build.CharacterBuildSupportAbility;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@AllArgsConstructor
public class CreateBuildSupportAbilitiesProcessor implements Processor<CreateBuildOperation, CreateBuildOperation> {

    private final CharacterBuildSupportAbilityRepository characterBuildSupportAbilityRepository;
    private final SupportAbilityRepository supportAbilityRepository;

    @Override
    @Transactional
    public CreateBuildOperation process(CreateBuildOperation createBuildOperation) {
        var supportAbilitiesId = createBuildOperation.getSupportAbilitiesId();
        supportAbilitiesId.forEach(supportAbilityId -> {
            CharacterBuildSupportAbility characterBuildSupportAbility = new CharacterBuildSupportAbility();

            var supportAbility = supportAbilityRepository.findById(supportAbilityId);
            characterBuildSupportAbility.setCharacterBuilt(createBuildOperation.getBuild());
            characterBuildSupportAbility.setSupportAbility(supportAbility);

            characterBuildSupportAbilityRepository.save(characterBuildSupportAbility);
        });
        return createBuildOperation;
    }
}
