package com.example.characterbuilderapp.core.repository.impl;

import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.core.repository.UserRepository;
import com.example.characterbuilderapp.domain.user.User;
import com.example.characterbuilderapp.infra.db.msql.repository.UserRepositoryMysql;
import com.example.characterbuilderapp.core.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.USER_NAO_ENCONTRADO;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryMysql userRepositoryMysql;

    @Override
    public boolean emailExists(String email) {
        return userRepositoryMysql.existsByEmail(email);
    }

    @Override
    public User createUser(User user) {
        var model = UserMapper.INSTANCE.mapToModel(user);
        var savedModel = userRepositoryMysql.save(model);
        return UserMapper.INSTANCE.mapToUser(savedModel);
    }

    @Override
    public User findById(Long id) {
        var model = userRepositoryMysql.findById(id).orElseThrow(()-> new ObjectNotFoundException(USER_NAO_ENCONTRADO));
        return UserMapper.INSTANCE.mapToUser(model);
    }
}
