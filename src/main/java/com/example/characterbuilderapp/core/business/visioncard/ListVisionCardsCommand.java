package com.example.characterbuilderapp.core.business.visioncard;

import com.example.characterbuilderapp.core.operations.visioncard.ListVisionCardsOperation;

public interface ListVisionCardsCommand {

    ListVisionCardsOperation execute(ListVisionCardsOperation operation);
}
