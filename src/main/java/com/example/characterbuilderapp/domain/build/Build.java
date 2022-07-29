package com.example.characterbuilderapp.domain.build;

import com.example.characterbuilderapp.domain.character.Character;
import com.example.characterbuilderapp.domain.esper.Esper;
import com.example.characterbuilderapp.domain.reaction.Reaction;
import com.example.characterbuilderapp.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Build {

    private String name;
    private Character character;
    private Esper esper;
    private Reaction reaction;
    private User user;
}
