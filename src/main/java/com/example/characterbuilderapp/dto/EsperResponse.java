package com.example.characterbuilderapp.dto;

import com.example.characterbuilderapp.domain.element.Element;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@AllArgsConstructor
@Getter
public class EsperResponse {

    private Long id;
    private String name;
    private String image;
    private String rarity;
    private ElementResponse element;
}
