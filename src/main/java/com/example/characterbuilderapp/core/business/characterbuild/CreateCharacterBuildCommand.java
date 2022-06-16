package com.example.characterbuilderapp.core.business.characterbuild;

import com.example.characterbuilderapp.core.operations.CreateCharacterBuildOperation;

public interface CreateCharacterBuildCommand {

    CreateCharacterBuildOperation execute(CreateCharacterBuildOperation operation);
}
