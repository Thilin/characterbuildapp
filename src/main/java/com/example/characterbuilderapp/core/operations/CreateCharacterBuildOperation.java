package com.example.characterbuilderapp.core.operations;

import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltModel;
import com.example.characterbuilderapp.dto.BuildRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCharacterBuildOperation {
    private BuildRequest buildRequest;
    private CharacterBuiltModel characterBuilt;
}
