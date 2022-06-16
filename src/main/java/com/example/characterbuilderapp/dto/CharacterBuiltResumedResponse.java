package com.example.characterbuilderapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterBuiltResumedResponse {

    private Long id;
    private String name;
    private CharacterResponse character;
    private EsperResponse esper;
    private List<EquipmentResponse> equipments;
    private List<VisionCardResponse> visioncards;
}
