package com.example.characterbuilderapp.core.business.character;

import com.example.characterbuilderapp.core.operations.character.FindCharacterDetailsOperation;

public interface FindCharacterDetailsCommand {

    FindCharacterDetailsOperation execute(FindCharacterDetailsOperation operation);
}
