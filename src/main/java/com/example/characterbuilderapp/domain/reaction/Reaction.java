package com.example.characterbuilderapp.domain.reaction;

import com.example.characterbuilderapp.domain.job.Job;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Reaction {

    private Long id;
    private String description;
    private Job job;
}
