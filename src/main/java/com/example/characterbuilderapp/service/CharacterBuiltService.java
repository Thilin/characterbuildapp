package com.example.characterbuilderapp.service;

import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltModel;
import com.example.characterbuilderapp.dto.BuildRequest;
import com.example.characterbuilderapp.dto.CharacterBuiltDetailedResponse;
import com.example.characterbuilderapp.dto.CharacterBuiltResumedResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface CharacterBuiltService {

    public CharacterBuiltModel findById(Long id);
    public Page<CharacterBuiltModel> pageAllByUserId(Long id, Pageable pageable);
    public CharacterBuiltModel createByUserId(BuildRequest buildDTO) throws ExecutionException, InterruptedException;

    List<CharacterBuiltResumedResponse> findResumedBuildByUserId(Long userId);

    CharacterBuiltDetailedResponse findDetailedBuildById(Long id);
}
