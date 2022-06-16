package com.example.characterbuilderapp.domain.character;

import com.example.characterbuilderapp.domain.job.Job;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class CharacterJob {

    private List<Job> jobs;
    private Character character;
}
