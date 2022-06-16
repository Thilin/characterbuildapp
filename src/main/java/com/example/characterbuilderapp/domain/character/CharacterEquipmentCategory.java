package com.example.characterbuilderapp.domain.character;

import com.example.characterbuilderapp.domain.equipment.EquipmentCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class CharacterEquipmentCategory {

    private List<Character> characters;
    private EquipmentCategory equipmentCategory;
}
