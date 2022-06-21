package com.example.characterbuilderapp.core.business.character;

import com.example.characterbuilderapp.core.operations.character.CharacterOperation;

public interface FindCharacterByIdCommand {

    CharacterOperation execute(CharacterOperation operation);
}
