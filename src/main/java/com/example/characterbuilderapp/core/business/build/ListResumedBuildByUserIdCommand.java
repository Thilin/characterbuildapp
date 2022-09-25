package com.example.characterbuilderapp.core.business.build;

import com.example.characterbuilderapp.core.operations.build.ListResumedBuildOperation;

public interface ListResumedBuildByUserIdCommand {

    ListResumedBuildOperation execute(ListResumedBuildOperation operation);
}
