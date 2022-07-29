package com.example.characterbuilderapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBuildDTO {

    private String name;
    private Long characterId;
    private Long esperId;
    private Long reactionId;
    private Long userId;
}
