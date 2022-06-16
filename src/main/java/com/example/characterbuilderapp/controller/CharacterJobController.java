package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.dto.JobResponse;
import com.example.characterbuilderapp.mapper.JobMapper;
import com.example.characterbuilderapp.service.CharacterJobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.characterbuilderapp.mapper.JobMapper.INSTANCE;

@RestController
@RequestMapping(name = "/characterjobs")
public class CharacterJobController {

    private final CharacterJobService characterJobService;

    public CharacterJobController(CharacterJobService characterJobService){
        this.characterJobService = characterJobService;
    }

    @GetMapping(value = "/{characterId}", produces = "application/json")
    public ResponseEntity<List<JobResponse>> listJobsByCharacterId(@PathVariable Long characterId){
        var characterJobs = characterJobService.findJobsByCharacterId(characterId);
        return ResponseEntity.ok(characterJobs.stream().map(characterJob -> INSTANCE.mapToDTO(characterJob.getJob())).collect(Collectors.toList()));
    }
}
