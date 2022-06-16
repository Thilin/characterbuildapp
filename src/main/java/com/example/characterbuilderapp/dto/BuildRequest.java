package com.example.characterbuilderapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildRequest {

    private Long userId;
    private String name;
    private Long characterId;
    private Long esperId;
    private Long reactionId;
    private List<Long> supportAbilityId;
    private List<Long> jobsId;
    private List<Long> equipmentsId;
    private List<VisionCardsBuildRequest> visionCards;

}
