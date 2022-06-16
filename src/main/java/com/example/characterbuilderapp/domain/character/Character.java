package com.example.characterbuilderapp.domain.character;

import com.example.characterbuilderapp.domain.element.Element;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Character {

    private String name;
    private String image;
    private String rarity;
    private Element element;
}
