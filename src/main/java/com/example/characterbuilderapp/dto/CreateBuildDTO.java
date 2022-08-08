package com.example.characterbuilderapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    private List<Long> equipmentsId;
    private List<Long> jobsId;
    private List<Long> visionCardsId;
    private List<Long> supportAbilitiesId;
}
