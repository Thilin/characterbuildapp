package com.example.characterbuilderapp.core.business.supportability;

import com.example.characterbuilderapp.core.operations.supportability.SupportAbilityOperation;

public interface FindSupportAbilityByIdCommand {

    SupportAbilityOperation execute(SupportAbilityOperation operation);
}
