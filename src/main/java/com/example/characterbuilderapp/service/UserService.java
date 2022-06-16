package com.example.characterbuilderapp.service;

import com.example.characterbuilderapp.infra.db.msql.data.user.UserModel;

public interface UserService {

    public UserModel findById(Long id);
}
