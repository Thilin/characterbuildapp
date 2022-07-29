package com.example.characterbuilderapp.core.operations.build;

import com.example.characterbuilderapp.core.operations.character.CharacterOperation;
import com.example.characterbuilderapp.core.operations.user.UserOperation;
import com.example.characterbuilderapp.domain.build.Build;
import com.example.characterbuilderapp.domain.character.Character;
import com.example.characterbuilderapp.domain.esper.Esper;
import com.example.characterbuilderapp.domain.reaction.Reaction;
import com.example.characterbuilderapp.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CreateBuildOperation {

    private String name;
    private Long characterId;
    private Long esperId;
    private Long reactionId;
    private Long userId;
    private Character character;
    private Esper esper;
    private Reaction reaction;
    private User user;
    private Build build;
}
