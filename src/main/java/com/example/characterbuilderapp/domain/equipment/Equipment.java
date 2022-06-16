package com.example.characterbuilderapp.domain.equipment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Equipment {

    private String name;
    private String image;
    private String rarity;
    private boolean isTMR;
    private EquipmentType equipmentType;
    private EquipmentCategory equipmentCategory;
}
