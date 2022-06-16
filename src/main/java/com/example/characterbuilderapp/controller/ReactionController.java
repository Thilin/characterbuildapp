package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.dto.ReactionResponse;
import com.example.characterbuilderapp.mapper.ReactionMapper;
import com.example.characterbuilderapp.service.ReactionService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.characterbuilderapp.mapper.ReactionMapper.*;

@RestController
@RequestMapping(value = "/reactions")
public class ReactionController {

    private final ReactionService reactionService;

    public ReactionController(ReactionService reactionService){
        this.reactionService = reactionService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ReactionResponse> findById(@PathVariable Long id){
        var reaction = reactionService.findById(id);
        return ResponseEntity.ok(INSTANCE.mapToDTO(reaction));
    }

    @GetMapping(value = "/characters/{id}", produces = "application/json")
    public ResponseEntity<List<ReactionResponse>> findByCharacterId(@PathVariable Long id){
        var reactions = reactionService.findByCharacterId(id);
        return ResponseEntity.ok(reactions.stream().map(INSTANCE::mapToDTO).collect(Collectors.toList()));
    }
}
