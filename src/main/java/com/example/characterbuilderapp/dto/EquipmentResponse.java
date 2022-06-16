package com.example.characterbuilderapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentResponse {

    private Long id;
    private String name;
    private String image;
    private String rarity;
    private boolean isTMR;
    private EquipmentTypeResponse equipmentType;
    private EquipmentCategoryResponse equipmentCategory;
}
