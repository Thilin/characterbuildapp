package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.core.business.build.CreateBuildCommand;
import com.example.characterbuilderapp.core.business.build.ListResumedBuildByUserIdCommand;
import com.example.characterbuilderapp.core.operations.build.CreateBuildOperation;
import com.example.characterbuilderapp.dto.CreateBuildDTO;
import com.example.characterbuilderapp.core.operations.build.ListResumedBuildsResponse;
import com.example.characterbuilderapp.core.mapper.BuildMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ListResumedBuildsResponse> listBuildsByUserId(@PathVariable Long userId){
        ListResumedBuildsResponse operation = new ListResumedBuildsResponse();
        operation.setUserId(userId);
        listBuildByUserIdCommand.execute(operation);
        return ResponseEntity.ok().body(operation);
    }
}
