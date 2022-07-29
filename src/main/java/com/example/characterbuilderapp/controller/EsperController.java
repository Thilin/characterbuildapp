package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.core.business.esper.FindEsperByIdCommand;
import com.example.characterbuilderapp.dto.EsperResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.characterbuilderapp.mapper.EsperMapper.INSTANCE;

@RestController
@RequestMapping(value = "/espers")
@AllArgsConstructor
public class EsperController {

    private final FindEsperByIdCommand command;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<EsperResponse> findById(@PathVariable Long id) {
        var operation = INSTANCE.mapToOperation(id);
        command.execute(operation);
        return ResponseEntity.ok(INSTANCE.mapToResponse(operation));
    }
}
