package com.example.characterbuilderapp.domain.visioncard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class VisionCard {

    private Long id;
    private String description;
    private String image;
}
