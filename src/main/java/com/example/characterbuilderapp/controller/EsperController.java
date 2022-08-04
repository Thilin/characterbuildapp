package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.core.business.esper.FindEsperByIdCommand;
import com.example.characterbuilderapp.core.business.esper.ListAllEspersCommand;
import com.example.characterbuilderapp.core.operations.esper.ListAllEspersOperation;
import com.example.characterbuilderapp.dto.EsperResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.characterbuilderapp.core.mapper.EsperMapper.INSTANCE;

@RestController
@RequestMapping(value = "/espers")
@AllArgsConstructor
public class EsperController {

    private final FindEsperByIdCommand command;

    private final ListAllEspersCommand listAllEspersCommand;

    @GetMapping(value = "/{id}", produces = "application/json")
    @Operation(description = "Find esper by id")
    public ResponseEntity<EsperResponse> findById(@PathVariable Long id) {
        var operation = INSTANCE.mapToOperation(id);
        command.execute(operation);
        return ResponseEntity.ok(INSTANCE.mapToResponse(operation.getEsper()));
    }

    @GetMapping(produces = "application/json")
    @Operation(description = "List all espers")
    public ResponseEntity<List<EsperResponse>> listAll(){
        var operation = new ListAllEspersOperation();
        listAllEspersCommand.execute(operation);
        return ResponseEntity.ok().body(operation.getEspers().stream().map(INSTANCE::mapToResponse).collect(Collectors.toList()));
    }
}
