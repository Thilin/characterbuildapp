package com.example.characterbuilderapp.core.business.user;

import com.example.characterbuilderapp.core.operations.user.UserOperation;

public interface CreateUserCommand {

    UserOperation execute (UserOperation operation);
}
