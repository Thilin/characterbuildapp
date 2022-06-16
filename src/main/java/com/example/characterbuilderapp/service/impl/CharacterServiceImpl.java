package com.example.characterbuilderapp.service.impl;

import com.example.characterbuilderapp.infra.db.msql.data.character.CharacterModel;
import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.infra.db.msql.repository.CharacterRepositoryMysql;
import com.example.characterbuilderapp.service.CharacterService;
import com.example.characterbuilderapp.service.JobService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.*;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepositoryMysql characterRepository;
    private final JobService jobService;

    public CharacterServiceImpl(CharacterRepositoryMysql characterRepository, JobService jobService){
        this.characterRepository = characterRepository;
        this.jobService = jobService;
    }

    @Override
    public CharacterModel findById(Long id) {
        return characterRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException(CHARACTER_NAO_ENCONTRADO));
    }

    @Override
    public Page<CharacterModel> pageAll(String name, Pageable pageable) {
        if(name != null)
            return characterRepository.findByName(name, pageable);
        else
            return characterRepository.findAll(pageable);
    }
}
