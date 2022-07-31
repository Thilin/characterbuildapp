package com.example.characterbuilderapp.dto;

import com.example.characterbuilderapp.domain.job.Job;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ReactionResponse {

    private Long id;
    private String description;
}
