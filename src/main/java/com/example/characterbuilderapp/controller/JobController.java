package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.core.business.job.ListJobsByCharacterIdCommand;
import com.example.characterbuilderapp.core.business.job.FindJobByIdCommand;
import com.example.characterbuilderapp.core.operations.job.ListCharacterJobsOperation;
import com.example.characterbuilderapp.dto.JobResponse;
import com.example.characterbuilderapp.core.mapper.CharacterMapper;
import com.example.characterbuilderapp.core.mapper.JobMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.characterbuilderapp.core.mapper.JobMapper.INSTANCE;


@RestController
@RequestMapping(value = "/jobs")
@AllArgsConstructor
public class JobController {

    private final FindJobByIdCommand command;


    private final ListJobsByCharacterIdCommand listJobsByCharacterIdCommand;

    @GetMapping(value = "/{id}", produces = "application/json")
    @Operation(description = "Find a job")
    public ResponseEntity<JobResponse> findById(@PathVariable Long id) {
        var operation = INSTANCE.mapToOperation(id);
        command.execute(operation);
        return ResponseEntity.ok(INSTANCE.mapToResponse(operation));
    }

    @GetMapping(value = "/character/{id}", produces = "Application/json")
    @Operation(description = "List all character's jobs")
    public ResponseEntity<List<JobResponse>> listJobsByCharacterId(@PathVariable Long id){
        ListCharacterJobsOperation operation = CharacterMapper.INSTANCE.mapToListCharacterJobsOperation(id);
        listJobsByCharacterIdCommand.execute(operation);
        return ResponseEntity.ok(operation.getJobs().stream().map(JobMapper.INSTANCE::mapToResponse).collect(Collectors.toList()));
    }
}
