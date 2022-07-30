package com.example.characterbuilderapp.core.operations.supportability;

import com.example.characterbuilderapp.domain.job.Job;
import com.example.characterbuilderapp.domain.supportability.SupportAbility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ListSupportAbilitiesByCharacterIdOperation {

    private Long characterId;
    private List<Job> jobs;
    private List<SupportAbility> supportAbilities;
}
