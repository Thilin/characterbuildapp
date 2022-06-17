package com.example.characterbuilderapp.core.business.job;

import com.example.characterbuilderapp.core.operations.job.JobOperation;

public interface FindJobByIdCommand {

    JobOperation execute(JobOperation operation);
}
