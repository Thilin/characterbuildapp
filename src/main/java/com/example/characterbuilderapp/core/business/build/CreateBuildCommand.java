package com.example.characterbuilderapp.core.business.build;

import com.example.characterbuilderapp.core.operations.build.CreateBuildOperation;

public interface CreateBuildCommand {

    CreateBuildOperation execute(CreateBuildOperation operation);
}
