package com.example.characterbuilderapp.core.business.build;

import com.example.characterbuilderapp.core.operations.build.ListResumedBuildsResponse;

public interface ListResumedBuildByUserIdCommand {

    ListResumedBuildsResponse execute(ListResumedBuildsResponse operation);
}
