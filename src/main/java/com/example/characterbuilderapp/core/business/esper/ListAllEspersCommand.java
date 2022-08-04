package com.example.characterbuilderapp.core.business.esper;

import com.example.characterbuilderapp.core.operations.esper.ListAllEspersOperation;

public interface ListAllEspersCommand {

    ListAllEspersOperation execute(ListAllEspersOperation operation);
}
