package com.example.characterbuilderapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class JobResponse {

    private Long id;
    private String description;
    private String image;
}
