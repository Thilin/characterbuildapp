package com.example.characterbuilderapp.usecases.character.processors;

import com.example.characterbuilderapp.core.operations.character.FindCharacterDetailsOperation;
import com.example.characterbuilderapp.core.repository.SupportAbilityRepository;
import com.example.characterbuilderapp.domain.supportability.SupportAbility;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class FindAllCharactersSupportAbilitiesProcessor implements Processor<FindCharacterDetailsOperation, FindCharacterDetailsOperation> {

    private final SupportAbilityRepository supportAbilityRepository;

    @Override
    public FindCharacterDetailsOperation process(FindCharacterDetailsOperation findCharacterDetailsOperation) {
        var supportAbilitiesList = new ArrayList<SupportAbility>();
        var jobs = findCharacterDetailsOperation.getJobs();
        jobs.forEach(job -> {
            var supportAbilities = supportAbilityRepository.findByJobId(job.getId());
            supportAbilities.forEach(supportAbility -> supportAbilitiesList.add(supportAbility));
        });
        findCharacterDetailsOperation.setSupportAbilities(supportAbilitiesList);
        return findCharacterDetailsOperation;
    }
}
