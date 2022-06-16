package com.example.characterbuilderapp.service;

import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltModel;
import com.example.characterbuilderapp.infra.db.msql.data.visioncard.VisionCardModel;
import com.example.characterbuilderapp.dto.VisionCardsBuildRequest;

import java.util.List;

public interface CharacterBuiltVisionCardService {

    public void saveVisionCardBuild(List<VisionCardsBuildRequest> visionCards, CharacterBuiltModel characterBuilt);
    public List<VisionCardModel> findByBuiltId(Long id);
}
