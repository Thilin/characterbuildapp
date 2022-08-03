package com.example.characterbuilderapp.core.operations.character;

import com.example.characterbuilderapp.domain.character.Character;
import com.example.characterbuilderapp.domain.job.Job;
import com.example.characterbuilderapp.domain.reaction.Reaction;
import com.example.characterbuilderapp.domain.supportability.SupportAbility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FindCharacterDetailsOperation {

    private Long id;
    private Character character;
    private List<Job> jobs;
    private List<Reaction> reactions;
    private List<SupportAbility> supportAbilities;
}
