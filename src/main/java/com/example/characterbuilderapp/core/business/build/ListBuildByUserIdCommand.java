package com.example.characterbuilderapp.core.business.build;

import com.example.characterbuilderapp.dto.ListBuildByUserIdOperation;

import java.util.List;

public interface ListBuildByUserIdCommand {

    ListBuildByUserIdOperation execute(ListBuildByUserIdOperation operation);
}
