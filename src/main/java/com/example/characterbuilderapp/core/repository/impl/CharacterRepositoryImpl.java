package com.example.characterbuilderapp.core.repository.impl;

import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.core.repository.CharacterRepository;
import com.example.characterbuilderapp.domain.character.Character;
import com.example.characterbuilderapp.infra.db.msql.repository.CharacterRepositoryMysql;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.*;
import static com.example.characterbuilderapp.core.mapper.CharacterMapper.*;

@Repository
@AllArgsConstructor
public class CharacterRepositoryImpl implements CharacterRepository {

    private final CharacterRepositoryMysql characterRepositoryMysql;
    @Override
    public Character findById(Long id) {
        var model = characterRepositoryMysql.findById(id).orElseThrow(()-> new ObjectNotFoundException(CHARACTER_NAO_ENCONTRADO));
        return INSTANCE.mapToDomain(model);
    }

    @Override
    public List<Character> findAll() {
        var models = characterRepositoryMysql.findAll();
        return models.stream().map(INSTANCE::mapToDomain).collect(Collectors.toList());
    }
}
