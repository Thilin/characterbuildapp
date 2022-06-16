package com.example.characterbuilderapp.service.impl;

import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltModel;
import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltVisionCardModel;
import com.example.characterbuilderapp.infra.db.msql.data.visioncard.VisionCardModel;
import com.example.characterbuilderapp.dto.VisionCardsBuildRequest;
import com.example.characterbuilderapp.infra.db.msql.repository.CharacterBuiltVisionCardRepositoryMysql;
import com.example.characterbuilderapp.service.CharacterBuiltVisionCardService;
import com.example.characterbuilderapp.service.VisionCardService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterBuiltVisionCardServiceImpl implements CharacterBuiltVisionCardService {

    private final CharacterBuiltVisionCardRepositoryMysql characterBuiltVisionCardRepository;
    private final VisionCardService visionCardService;

    public CharacterBuiltVisionCardServiceImpl(CharacterBuiltVisionCardRepositoryMysql characterBuiltVisionCardRepository,
                                               VisionCardService visionCardService){
        this.characterBuiltVisionCardRepository = characterBuiltVisionCardRepository;
        this.visionCardService = visionCardService;
    }

    @Override
    public void saveVisionCardBuild(List<VisionCardsBuildRequest> visionCards, CharacterBuiltModel characterBuilt) {
        if(visionCards != null){
            visionCards.forEach(visionCard -> {
                var characterBuiltVisionCard = new CharacterBuiltVisionCardModel();
                var visioncard = visionCardService.findById(visionCard.getId());

                characterBuiltVisionCard.setCharacterBuilt(characterBuilt);
                characterBuiltVisionCard.setVisionCard(visioncard);
                characterBuiltVisionCard.setMain(visionCard.isMain());

                characterBuiltVisionCardRepository.save(characterBuiltVisionCard);
            });
        }
    }

    @Override
    public List<VisionCardModel> findByBuiltId(Long id) {
        var visionCards = new ArrayList<VisionCardModel>();
        var characterBuiltVisioncards = characterBuiltVisionCardRepository.findByCharacterBuiltId(id);
        characterBuiltVisioncards.forEach(characterBuiltVisionCard -> visionCards.add(characterBuiltVisionCard.getVisionCard()));
        return visionCards;
    }
}
