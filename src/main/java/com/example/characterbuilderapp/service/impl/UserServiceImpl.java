package com.example.characterbuilderapp.service.impl;

import com.example.characterbuilderapp.infra.db.msql.data.user.UserModel;
import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.infra.db.msql.repository.UserRepositoryMysql;
import com.example.characterbuilderapp.service.UserService;
import org.springframework.stereotype.Service;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepositoryMysql userRepository;

    public UserServiceImpl(UserRepositoryMysql userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserModel findById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException(USER_NAO_ENCONTRADO));
    }
}
