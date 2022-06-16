package com.example.characterbuilderapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterBuiltDetailedResponse {

    private Long id;
    private String name;
    private CharacterResponse character;
    private EsperResponse esper;
    private List<EquipmentResponse> equipments;
    private List<VisionCardResponse> visioncards;
    private ReactionResponse reaction;
    private List<SupportAbilityResponse> supportAbilities;
    private List<JobResponse> jobs;
}
