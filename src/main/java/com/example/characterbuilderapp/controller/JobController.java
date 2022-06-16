package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.dto.JobResponse;
import com.example.characterbuilderapp.mapper.JobMapper;
import com.example.characterbuilderapp.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.characterbuilderapp.mapper.JobMapper.*;

@RestController
@RequestMapping(value = "/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService){
        this.jobService = jobService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<JobResponse> findById(@PathVariable Long id){
        var job = jobService.findById(id);
        return ResponseEntity.ok(INSTANCE.mapToDTO(job));
    }
}
