package com.example.characterbuilderapp.core.business.character;

import com.example.characterbuilderapp.core.operations.character.ListAllCharactersOperation;

public interface ListAllCharactersCommand {

    ListAllCharactersOperation execute(ListAllCharactersOperation operation);
}
