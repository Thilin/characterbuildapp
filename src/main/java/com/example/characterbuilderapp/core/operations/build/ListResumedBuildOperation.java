package com.example.characterbuilderapp.core.operations.build;

import com.example.characterbuilderapp.domain.build.Build;
import com.example.characterbuilderapp.domain.character.Character;
import com.example.characterbuilderapp.domain.equipment.Equipment;
import com.example.characterbuilderapp.domain.esper.Esper;
import com.example.characterbuilderapp.domain.visioncard.VisionCard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ListResumedBuildOperation {

    private Long userId;
    private List<Build> builds;
    private List<VisionCard> visionCards;
    private List<Equipment> equipments;
}
