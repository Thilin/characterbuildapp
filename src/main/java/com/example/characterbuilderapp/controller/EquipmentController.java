package com.example.characterbuilderapp.controller;

import com.example.characterbuilderapp.dto.EquipmentResponse;
import com.example.characterbuilderapp.mapper.EquipmentMapper;
import com.example.characterbuilderapp.service.EquipmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.characterbuilderapp.mapper.EquipmentMapper.*;

@RestController
@RequestMapping(value = "/equipments")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService){
        this.equipmentService = equipmentService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EquipmentResponse> findById(@PathVariable Long id){
        var equipment = equipmentService.findById(id);
        return ResponseEntity.ok(INSTANCE.mapToDTO(equipment));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Page<EquipmentResponse>> pageAll(Pageable pageable, @RequestParam String name){
        var equipments = equipmentService.pageAll(name, pageable);
        return ResponseEntity.ok(equipments.map(INSTANCE::mapToDTO));
    }
}
