package com.example.characterbuilderapp.core.business.supportability;

import com.example.characterbuilderapp.core.operations.supportability.ListSupportAbilitiesByCharacterIdOperation;

public interface ListCharacterSupportAbilitiesCommand {

    ListSupportAbilitiesByCharacterIdOperation execute(ListSupportAbilitiesByCharacterIdOperation operation);
}
