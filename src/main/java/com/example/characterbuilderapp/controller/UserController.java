package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.core.business.user.CreateUserCommand;
import com.example.characterbuilderapp.core.business.user.FindUserByIdCommand;
import com.example.characterbuilderapp.dto.CreateUserdto;
import com.example.characterbuilderapp.dto.UserResponse;
import com.example.characterbuilderapp.core.operations.user.UserOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.characterbuilderapp.core.mapper.UserMapper.INSTANCE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final CreateUserCommand createUserCommand;
    private final FindUserByIdCommand findUserByIdCommand;


    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id){
        var operation = INSTANCE.mapToOperationById(id);
        findUserByIdCommand.execute(operation);
        return ResponseEntity.ok(INSTANCE.mapToResponse(operation));
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<UserResponse> create(@RequestBody CreateUserdto dto){
        UserOperation operation = INSTANCE.mapToOperation(dto);
        createUserCommand.execute(operation);
        return ResponseEntity.ok().body(INSTANCE.mapToResponse(operation));
    }
}
