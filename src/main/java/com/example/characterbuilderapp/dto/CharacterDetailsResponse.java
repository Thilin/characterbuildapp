package com.example.characterbuilderapp.dto;

import com.example.characterbuilderapp.domain.character.Character;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDetailsResponse {

    private Long id;
    private String name;
    private String image;
    private String rarity;
    private ElementResponse element;
    private List<JobResponse> jobs;
    private List<ReactionResponse> reactions;
    private List<SupportAbilityResponse> supportAbilities;
}
