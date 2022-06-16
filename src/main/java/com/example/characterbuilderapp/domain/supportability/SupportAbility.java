package com.example.characterbuilderapp.domain.supportability;

import com.example.characterbuilderapp.domain.job.Job;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class SupportAbility {

    private Long id;
    private String description;
    private Job job;
}
