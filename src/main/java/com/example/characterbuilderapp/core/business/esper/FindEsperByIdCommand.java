package com.example.characterbuilderapp.core.business.esper;

import com.example.characterbuilderapp.core.operations.esper.EsperOperation;

public interface FindEsperByIdCommand {

    EsperOperation execute(EsperOperation operation);
}
