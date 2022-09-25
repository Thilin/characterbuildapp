package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.core.business.build.CreateBuildCommand;
import com.example.characterbuilderapp.core.business.build.ListResumedBuildByUserIdCommand;
import com.example.characterbuilderapp.core.operations.build.CreateBuildOperation;
import com.example.characterbuilderapp.core.operations.build.ListResumedBuildOperation;
import com.example.characterbuilderapp.domain.equipment.Equipment;
import com.example.characterbuilderapp.dto.CreateBuildDTO;
import com.example.characterbuilderapp.dto.ListResumedBuildResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.characterbuilderapp.core.mapper.BuildMapper.*;

@AllArgsConstructor
@RequestMapping(value = "/builds")
@RestController
public class BuildController {

    private final CreateBuildCommand createBuildCommand;
    private final ListResumedBuildByUserIdCommand listBuildByUserIdCommand;

    @PostMapping()
    public ResponseEntity<Long> create(@RequestBody CreateBuildDTO dto){
        CreateBuildOperation operation = INSTANCE.mapToOperation(dto);
        createBuildCommand.execute(operation);

        return ResponseEntity.ok().body(operation.getBuild().getId());
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<ListResumedBuildResponse> listBuildsByUserId(@PathVariable Long userId){
        ListResumedBuildOperation operation = new ListResumedBuildOperation();
        operation.setUserId(userId);
        listBuildByUserIdCommand.execute(operation);
        return ResponseEntity.ok().body(INSTANCE.mapToResponse(operation));
    }
}
