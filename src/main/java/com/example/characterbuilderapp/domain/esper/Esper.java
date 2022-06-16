package com.example.characterbuilderapp.domain.esper;

import com.example.characterbuilderapp.domain.element.Element;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Esper {

    private String name;
    private String image;
    private String rarity;
    private Element element;
}
