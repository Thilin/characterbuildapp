package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.dto.EsperResponse;
import com.example.characterbuilderapp.mapper.EsperMapper;
import com.example.characterbuilderapp.service.EsperService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.characterbuilderapp.mapper.EsperMapper.*;

@RestController
@RequestMapping(value = "/espers")
public class EsperController {

    private final EsperService esperService;

    public EsperController(EsperService esperService){
        this.esperService = esperService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EsperResponse> findById(@PathVariable Long id){
        var esper = esperService.findById(id);
        return ResponseEntity.ok(INSTANCE.mapToDTO(esper));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Page<EsperResponse>> pageAll(Pageable pageable,
                                                       @RequestParam(required = false) String name){
        var espers = esperService.pageAll(name, pageable);
        return ResponseEntity.ok(espers.map(INSTANCE::mapToDTO));
    }
}
