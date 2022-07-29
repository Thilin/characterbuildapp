package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.core.business.build.CreateBuildCommand;
import com.example.characterbuilderapp.core.business.build.ListBuildByUserIdCommand;
import com.example.characterbuilderapp.core.operations.build.CreateBuildOperation;
import com.example.characterbuilderapp.dto.CreateBuildDTO;
import com.example.characterbuilderapp.dto.ListBuildByUserIdOperation;
import com.example.characterbuilderapp.mapper.BuildMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping(value = "/builds")
@RestController
public class BuildController {

    private final CreateBuildCommand createBuildCommand;
    private final ListBuildByUserIdCommand listBuildByUserIdCommand;

    @PostMapping()
    public ResponseEntity<CreateBuildOperation> create(@RequestBody CreateBuildDTO dto){
        CreateBuildOperation operation = BuildMapper.INSTANCE.mapToOperation(dto);
        createBuildCommand.execute(operation);

        return ResponseEntity.ok().body(operation);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<ListBuildByUserIdOperation> listBuildsByUserId(@PathVariable Long userId){
        ListBuildByUserIdOperation operation = new ListBuildByUserIdOperation();
        operation.setUserId(userId);
        listBuildByUserIdCommand.execute(operation);
        return ResponseEntity.ok().body(operation);
    }
}
