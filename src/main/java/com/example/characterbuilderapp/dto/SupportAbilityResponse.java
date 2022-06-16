package com.example.characterbuilderapp.dto;

import com.example.characterbuilderapp.domain.job.Job;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class SupportAbilityResponse {

    private Long id;
    private String description;
    private JobResponse job;
}
