package com.example.characterbuilderapp.domain.job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Job {

    private Long id;
    private String description;
    private String image;
}
