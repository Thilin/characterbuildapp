package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.core.business.reaction.FindReactionByIdCommand;
import com.example.characterbuilderapp.core.business.reaction.ListCharacterReactionsCommand;
import com.example.characterbuilderapp.core.operations.reaction.ListCharacterReactionsOperation;
import com.example.characterbuilderapp.dto.ReactionResponse;
import com.example.characterbuilderapp.core.mapper.ReactionMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.characterbuilderapp.core.mapper.ReactionMapper.INSTANCE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/reactions")
public class ReactionController {

    private final FindReactionByIdCommand command;
    private final ListCharacterReactionsCommand listCharacterReactionsCommand;

    @GetMapping(value = "/{id}", produces = "application/json")
    @Operation(description = "Find a reaction")
    public ResponseEntity<ReactionResponse> findById(@PathVariable Long id){
        var operation = ReactionMapper.INSTANCE.mapToOperation(id);
        command.execute(operation);
        return ResponseEntity.ok(INSTANCE.mapToResponse(operation.getReaction()));
    }

    @GetMapping(value = "/characters/{id}", produces = "application/json")
    @Operation(description = "Find all reactions for a character")
    public ResponseEntity<List<ReactionResponse>> listAllByCharacterId(@PathVariable Long id){
        var operation = new ListCharacterReactionsOperation();
        operation.setCharacterId(id);
        listCharacterReactionsCommand.execute(operation);
        return ResponseEntity.ok().body(operation.getReactions().stream().map(INSTANCE::mapToResponse).collect(Collectors.toList()));
    }
}
