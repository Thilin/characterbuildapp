package com.example.characterbuilderapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CharacterResponse {

    private Long id;
    private String name;
    private String image;
    private String rarity;
    private ElementResponse element;
}
