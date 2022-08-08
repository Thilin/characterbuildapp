package com.example.characterbuilderapp.domain.build;

import com.example.characterbuilderapp.domain.supportability.SupportAbility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterBuildSupportAbility {
    private Long id;
    private SupportAbility supportAbility;
    private Build characterBuilt;
}
