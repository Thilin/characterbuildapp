package com.example.characterbuilderapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EsperResponse {

    private Long id;
    private String name;
    private String image;
    private String rarity;
    private ElementResponse element;
}
