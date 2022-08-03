package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.core.business.character.FindCharacterByIdCommand;
import com.example.characterbuilderapp.core.business.character.ListAllCharactersCommand;
import com.example.characterbuilderapp.core.operations.character.ListAllCharactersOperation;
import com.example.characterbuilderapp.dto.CharacterResponse;
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

    private final FindCharacterByIdCommand findCharacterByIdCommand;
    private final ListAllCharactersCommand listAllCharactersCommand;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CharacterResponse> findById(@PathVariable Long id){
        var operation = INSTANCE.mapToOperation(id);
        findCharacterByIdCommand.execute(operation);
        return ResponseEntity.ok(INSTANCE.mapToResponse(operation.getCharacter()));
    }

    @GetMapping()
    @Operation(description = "List all characters resumed")
    public ResponseEntity<List<CharacterResponse>> listAll(){
        ListAllCharactersOperation operation = new ListAllCharactersOperation();
        listAllCharactersCommand.execute(operation);
        return ResponseEntity.ok().body(operation.getCharacters().stream().map(character -> INSTANCE.mapToResponse(character)).collect(Collectors.toList()));
    }
}
