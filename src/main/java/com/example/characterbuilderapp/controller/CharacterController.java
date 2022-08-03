package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.core.business.character.FindCharacterDetailsCommand;
import com.example.characterbuilderapp.core.business.character.ListAllCharactersCommand;
import com.example.characterbuilderapp.core.operations.character.FindCharacterDetailsOperation;
import com.example.characterbuilderapp.core.operations.character.ListAllCharactersOperation;
import com.example.characterbuilderapp.dto.CharacterDetailsResponse;
import com.example.characterbuilderapp.dto.CharactersListResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.characterbuilderapp.core.mapper.CharacterMapper.*;

@RestController
@RequestMapping(value = "/characters")
@AllArgsConstructor
public class CharacterController {

    private final FindCharacterDetailsCommand findCharacterByIdCommand;
    private final ListAllCharactersCommand listAllCharactersCommand;

    @GetMapping(value = "/{id}", produces = "application/json")
    @Operation(description = "Find a character by id and show its details")
    public ResponseEntity<CharacterDetailsResponse> findById(@PathVariable Long id){
        var operation = new FindCharacterDetailsOperation();
        operation.setId(id);
        findCharacterByIdCommand.execute(operation);
        return ResponseEntity.ok(INSTANCE.mapToCharacterDetailsResponse(operation));
    }

    @GetMapping()
    @Operation(description = "List all characters resumed")
    public ResponseEntity<List<CharactersListResponse>> listAll(){
        ListAllCharactersOperation operation = new ListAllCharactersOperation();
        listAllCharactersCommand.execute(operation);
        return ResponseEntity.ok().body(operation.getCharacters().stream().map(INSTANCE::mapToResponse).collect(Collectors.toList()));
    }
}
