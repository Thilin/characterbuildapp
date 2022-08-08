package com.example.characterbuilderapp.core.repository.impl;

import com.example.characterbuilderapp.core.mapper.CharacterBuiltVisionCardMapper;
import com.example.characterbuilderapp.core.repository.CharacterBuildVisionCardRepository;
import com.example.characterbuilderapp.domain.build.CharacterBuiltVisionCard;
import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltVisionCardModel;
import com.example.characterbuilderapp.infra.db.msql.repository.CharacterBuiltVisionCardRepositoryMysql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.characterbuilderapp.core.mapper.CharacterBuiltVisionCardMapper.*;

@Repository
@AllArgsConstructor
public class CharacterBuildVisionCardRepositoryImpl implements CharacterBuildVisionCardRepository {

    private final CharacterBuiltVisionCardRepositoryMysql characterBuiltVisionCardRepositoryMysql;
    @Override
    public void save(CharacterBuiltVisionCard characterBuiltVisionCard) {
        var model = INSTANCE.mapToModel(characterBuiltVisionCard);
        characterBuiltVisionCardRepositoryMysql.save(model);
    }
}
