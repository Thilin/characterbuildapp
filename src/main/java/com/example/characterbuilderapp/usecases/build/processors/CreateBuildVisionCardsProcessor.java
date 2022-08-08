package com.example.characterbuilderapp.usecases.build.processors;

import com.example.characterbuilderapp.core.operations.build.CreateBuildOperation;
import com.example.characterbuilderapp.core.repository.CharacterBuildVisionCardRepository;
import com.example.characterbuilderapp.core.repository.VisionCardRepository;
import com.example.characterbuilderapp.domain.build.CharacterBuiltVisionCard;
import com.example.characterbuilderapp.utils.Processor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@AllArgsConstructor
public class CreateBuildVisionCardsProcessor implements Processor<CreateBuildOperation, CreateBuildOperation> {

    private VisionCardRepository visionCardRepository;
    private CharacterBuildVisionCardRepository characterBuildVisionCardRepository;

    @Override
    @Transactional
    public CreateBuildOperation process(CreateBuildOperation createBuildOperation) {
        var visionCardsId = createBuildOperation.getVisionCardsId();
        visionCardsId.forEach(visionCardId -> {
            CharacterBuiltVisionCard characterBuiltVisionCard = new CharacterBuiltVisionCard();
            var visionCard = visionCardRepository.findById(visionCardId);
            characterBuiltVisionCard.setVisionCard(visionCard);
            characterBuiltVisionCard.setCharacterBuilt(createBuildOperation.getBuild());

            characterBuildVisionCardRepository.save(characterBuiltVisionCard);
        });
        return createBuildOperation;
    }
}
