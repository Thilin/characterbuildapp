package com.example.characterbuilderapp.core.business.character;

import com.example.characterbuilderapp.core.operations.character.ListCharacterJobsOperation;

public interface ListJobsByCharacterIdCommand {

    ListCharacterJobsOperation execute(ListCharacterJobsOperation operation);
}
