package com.example.characterbuilderapp.domain.build;

import com.example.characterbuilderapp.domain.character.Character;
import com.example.characterbuilderapp.domain.equipment.Equipment;
import com.example.characterbuilderapp.domain.esper.Esper;
import com.example.characterbuilderapp.domain.visioncard.VisionCard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ResumedBuild {

    private String name;
    private Character character;
    private Esper esper;
    private List<VisionCard> visionCards;
    private List<Equipment> equipments;
}
