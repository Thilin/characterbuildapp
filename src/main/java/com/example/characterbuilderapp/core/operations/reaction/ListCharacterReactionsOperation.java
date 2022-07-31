package com.example.characterbuilderapp.core.operations.reaction;

import com.example.characterbuilderapp.domain.job.Job;
import com.example.characterbuilderapp.domain.reaction.Reaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListCharacterReactionsOperation {

    private Long characterId;
    private List<Job> jobs;
    private List<Reaction> reactions;
}
