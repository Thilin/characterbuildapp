package com.example.characterbuilderapp.domain.build;

import com.example.characterbuilderapp.domain.character.CharacterJob;
import com.example.characterbuilderapp.domain.job.Job;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CharacterBuildJob {

    private Long id;
    private boolean isMain;
    private CharacterJob characterJob;
    private Build characterBuilt;

}
