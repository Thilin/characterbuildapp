package com.example.characterbuilderapp.core.operations.character;

import com.example.characterbuilderapp.core.operations.job.JobOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class ListCharacterJobsOperation {

    private Long characterId;
    private List<JobOperation> jobs;
}
