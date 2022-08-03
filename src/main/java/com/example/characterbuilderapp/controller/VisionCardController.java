package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.core.business.visioncard.ListVisionCardsCommand;
import com.example.characterbuilderapp.core.business.visioncard.VisionCardCommand;
import com.example.characterbuilderapp.core.operations.visioncard.ListVisionCardsOperation;
import com.example.characterbuilderapp.core.operations.visioncard.VisionCardOperation;
import com.example.characterbuilderapp.dto.VisionCardResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.characterbuilderapp.core.mapper.VisionCardMapper.INSTANCE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/visioncards")
public class VisionCardController {

    private final VisionCardCommand visionCardCommand;
    private final ListVisionCardsCommand listVisionCardsCommand;

    @GetMapping(value = "/{id}", produces = "application/json")
    @Operation(description = "Finds a Vision Card by Id")
    public ResponseEntity<VisionCardResponse> findById(@PathVariable Long id){
        VisionCardOperation operation = INSTANCE.mapToOperation(id);
        visionCardCommand.execute(operation);
        return ResponseEntity.ok(INSTANCE.mapToResponse(operation.getVisionCard()));
    }

    @GetMapping(produces = "application/json")
    @Operation(description = "List all Vision Cards")
    public ResponseEntity<List<VisionCardResponse>> listAll(){
        var operation = new ListVisionCardsOperation();
        listVisionCardsCommand.execute(operation);
        return ResponseEntity.ok().body(operation.getVisionCards().stream().map(INSTANCE::mapToResponse).collect(Collectors.toList()));
    }
}
