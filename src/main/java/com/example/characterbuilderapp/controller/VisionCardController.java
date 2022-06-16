package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.core.business.visioncard.VisionCardCommand;
import com.example.characterbuilderapp.core.operations.visioncard.VisionCardOperation;
import com.example.characterbuilderapp.dto.VisionCardResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.characterbuilderapp.mapper.VisionCardMapper.INSTANCE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/visioncards")
public class VisionCardController {

    private final VisionCardCommand visionCardCommand;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<VisionCardResponse> findById(@PathVariable Long id){
        VisionCardOperation operation = INSTANCE.mapToOperation(id);
        visionCardCommand.execute(operation);
        return ResponseEntity.ok(INSTANCE.mapToResponse(operation));
    }
}
