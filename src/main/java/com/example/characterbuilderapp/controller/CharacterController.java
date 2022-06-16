package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.dto.CharacterResponse;
import com.example.characterbuilderapp.mapper.CharacterMapper;
import com.example.characterbuilderapp.service.CharacterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.characterbuilderapp.mapper.CharacterMapper.*;

@RestController
@RequestMapping(value = "/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CharacterResponse> findById(@PathVariable Long id){
        var character = characterService.findById(id);
        return ResponseEntity.ok(INSTANCE.mapToDTO(character));
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<Page<CharacterResponse>> pageAll(Pageable pageable,
                                                           @RequestParam String name){
        var characters = characterService.pageAll(name, pageable);
        return ResponseEntity.ok(characters.map(INSTANCE::mapToDTO));
    }
}
