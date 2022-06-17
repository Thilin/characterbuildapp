package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.core.business.job.FindJobByIdCommand;
import com.example.characterbuilderapp.dto.JobResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.characterbuilderapp.mapper.JobMapper.INSTANCE;


@RestController
@RequestMapping(value = "/jobs")
@AllArgsConstructor
public class JobController {

    private final FindJobByIdCommand command;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<JobResponse> findById(@PathVariable Long id) {
        var operation = INSTANCE.mapToOperation(id);
        command.execute(operation);
        return ResponseEntity.ok(INSTANCE.mapToResponse(operation));
    }
}
