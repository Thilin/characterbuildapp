package com.example.characterbuilderapp.core.business.job;

import com.example.characterbuilderapp.core.operations.job.ListCharacterJobsOperation;

public interface ListJobsByCharacterIdCommand {

    ListCharacterJobsOperation execute(ListCharacterJobsOperation operation);
}
