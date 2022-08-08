package com.example.characterbuilderapp.domain.build;

import com.example.characterbuilderapp.domain.equipment.Equipment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CharacterBuildEquipment {

    private Long id;
    private Equipment equipment;
    private Build characterBuilt;

}
