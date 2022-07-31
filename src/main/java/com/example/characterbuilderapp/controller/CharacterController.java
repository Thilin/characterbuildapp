package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.core.business.character.FindCharacterByIdCommand;
import com.example.characterbuilderapp.core.business.character.ListJobsByCharacterIdCommand;
import com.example.characterbuilderapp.core.operations.character.ListCharacterJobsOperation;
import com.example.characterbuilderapp.domain.job.Job;
import com.example.characterbuilderapp.dto.CharacterResponse;
import com.example.characterbuilderapp.dto.JobResponse;
import com.example.characterbuilderapp.mapper.CharacterMapper;
import com.example.characterbuilderapp.mapper.JobMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.characterbuilderapp.mapper.CharacterMapper.*;

@RestController
@RequestMapping(value = "/characters")
@AllArgsConstructor
public class CharacterController {

    private final FindCharacterByIdCommand findCharacterByIdCommand;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CharacterResponse> findById(@PathVariable Long id){
        var operation = INSTANCE.mapToOperation(id);
        findCharacterByIdCommand.execute(operation);
        return ResponseEntity.ok(INSTANCE.mapToResponse(operation));
    }
}
