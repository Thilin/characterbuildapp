package com.example.characterbuilderapp.core.repository;

import com.example.characterbuilderapp.domain.user.User;

public interface UserRepository {

    boolean emailExists(String email);

    User createUser(User operation);

    User findById(Long id);
}
