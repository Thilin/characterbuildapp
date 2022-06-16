package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.core.business.visioncard.VisionCardCommand;
import com.example.characterbuilderapp.core.operations.visioncard.VisionCardOperation;
import com.example.characterbuilderapp.dto.VisionCardResponse;
import com.example.characterbuilderapp.mapper.VisionCardMapper;
import com.example.characterbuilderapp.service.VisionCardService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.characterbuilderapp.mapper.VisionCardMapper.INSTANCE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/visioncards")
public class VisionCardController {

    private final VisionCardService visionCardService;
    private final VisionCardCommand visionCardCommand;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<VisionCardResponse> findById(@PathVariable Long id){
        VisionCardOperation operation = INSTANCE.mapToOperation(id);
        visionCardCommand.execute(operation);
        return ResponseEntity.ok(INSTANCE.mapToResponse(operation));
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<Page<VisionCardResponse>> pageAll(Pageable pageable,
                                                            @RequestParam(required = false) String description){
        var visionCards = visionCardService.pageAll(description, pageable);
        return ResponseEntity.ok(visionCards.map(INSTANCE::mapToDTO));
    }
}
