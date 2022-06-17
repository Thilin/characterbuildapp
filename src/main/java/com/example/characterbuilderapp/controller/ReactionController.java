package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.core.business.reaction.FindReactionByIdCommand;
import com.example.characterbuilderapp.dto.ReactionResponse;
import com.example.characterbuilderapp.mapper.ReactionMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.characterbuilderapp.mapper.ReactionMapper.INSTANCE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/reactions")
public class ReactionController {

    private final FindReactionByIdCommand command;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ReactionResponse> findById(@PathVariable Long id){
        var operation = ReactionMapper.INSTANCE.mapToOperation(id);
        command.execute(operation);
        return ResponseEntity.ok(INSTANCE.mapToResponse(operation));
    }
}
