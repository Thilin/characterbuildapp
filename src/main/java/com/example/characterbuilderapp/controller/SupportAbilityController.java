package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.core.business.supportability.FindSupportAbilityByIdCommand;
import com.example.characterbuilderapp.core.operations.supportability.SupportAbilityOperation;
import com.example.characterbuilderapp.core.operations.visioncard.VisionCardOperation;
import com.example.characterbuilderapp.dto.SupportAbilityResponse;
import com.example.characterbuilderapp.dto.VisionCardResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.characterbuilderapp.mapper.SupportAbilityMapper.INSTANCE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/supportabilities")
public class SupportAbilityController {

    private final FindSupportAbilityByIdCommand findSupportAbilityByIdCommand;

    @GetMapping(value = "/{id}", produces = "application/json")
    @Operation(description = "Find a support ability by id")
    public ResponseEntity<SupportAbilityResponse> findById(@PathVariable Long id){
        SupportAbilityOperation operation = INSTANCE.mapToOperation(id);
        findSupportAbilityByIdCommand.execute(operation);
        return ResponseEntity.ok(INSTANCE.mapToResponse(operation));
    }
}
