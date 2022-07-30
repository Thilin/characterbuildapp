package com.example.characterbuilderapp.usecases.processors.supportability;

import com.example.characterbuilderapp.core.operations.supportability.ListSupportAbilitiesByCharacterIdOperation;
import com.example.characterbuilderapp.core.repository.SupportAbilityRepository;
import com.example.characterbuilderapp.domain.supportability.SupportAbility;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ListSupportAbilityByCharacterIdProcessor implements Processor<ListSupportAbilitiesByCharacterIdOperation, ListSupportAbilitiesByCharacterIdOperation> {

    private final SupportAbilityRepository supportAbilityRepository;
    @Override
    public ListSupportAbilitiesByCharacterIdOperation process(ListSupportAbilitiesByCharacterIdOperation operation) {
        var supportAbilitiesList = new ArrayList<SupportAbility>();
        operation.getJobs().forEach(job -> {
            var supportAbilities = supportAbilityRepository.findByJobId(job.getId());
            supportAbilities.forEach(supportAbility -> supportAbilitiesList.add(supportAbility));
        });
        operation.setSupportAbilities(supportAbilitiesList);
        return operation;
    }
}
