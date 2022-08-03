package com.example.characterbuilderapp.core.operations.character;

import com.example.characterbuilderapp.domain.character.Character;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListAllCharactersOperation {

    private List<Character> characters;
}
