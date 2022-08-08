package com.example.characterbuilderapp.domain.build;

import com.example.characterbuilderapp.domain.visioncard.VisionCard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CharacterBuiltVisionCard {

    private Long id;
    private VisionCard visionCard;
    private Build characterBuilt;
}
