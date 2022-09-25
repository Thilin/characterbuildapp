package com.example.characterbuilderapp.dto;

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
public class ListResumedBuildResponse {

    private List<ResumedBuild> builds;
//    private List<VisionCard> visionCards;

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResumedCharacter{
        private String name;
        private String image;
        private String rarity;
        private Element element;
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Element{
        private String description;
        private String image;
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResumedBuild{
        private Long id;
        private String name;
        private ResumedCharacter character;
        private Esper esper;
        private List<Equipment> equipments;
    }

}


