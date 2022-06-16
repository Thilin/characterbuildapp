package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.dto.SupportAbilityResponse;
import com.example.characterbuilderapp.mapper.SupportAbilityMapper;
import com.example.characterbuilderapp.service.SupportAbilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.characterbuilderapp.mapper.SupportAbilityMapper.*;

@RestController
@RequestMapping(value = "/supportabilities")
public class SupportAbilityController {

    private final SupportAbilityService supportAbilityService;

    public SupportAbilityController(SupportAbilityService supportAbilityService){
        this.supportAbilityService = supportAbilityService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SupportAbilityResponse> findById(@PathVariable Long id){
        var supportAbility = supportAbilityService.findById(id);
        return ResponseEntity.ok(INSTANCE.mapToDTO(supportAbility));
    }

    @GetMapping(value = "/characters/{id}")
    public ResponseEntity<List<SupportAbilityResponse>> listByCharacterId(@PathVariable Long id){
        var supportAbilities = supportAbilityService.findByCharacterId(id);
        return ResponseEntity.ok(supportAbilities.stream().map(INSTANCE::mapToDTO).collect(Collectors.toList()));
    }
}
