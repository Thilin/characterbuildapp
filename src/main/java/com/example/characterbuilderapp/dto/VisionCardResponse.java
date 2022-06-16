package com.example.characterbuilderapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisionCardResponse {

    private Long id;
    private String description;
    private String image;
}
