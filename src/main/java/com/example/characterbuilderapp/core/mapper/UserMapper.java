package com.example.characterbuilderapp.core.mapper;

import com.example.characterbuilderapp.domain.user.User;
import com.example.characterbuilderapp.dto.CreateUserdto;
import com.example.characterbuilderapp.infra.db.msql.data.user.UserModel;
import com.example.characterbuilderapp.dto.UserResponse;
import com.example.characterbuilderapp.core.operations.user.UserOperation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract UserResponse mapToDTO(UserModel user);

    public abstract UserModel mapToModel(User user);

    public abstract User mapToUser(UserModel userModel);

    @Mapping(target = "user.name", source = "name")
    @Mapping(target = "user.username", source = "username")
    @Mapping(target = "user.email", source = "email")
    @Mapping(target = "user.password", source = "password")
    public abstract UserOperation mapToOperation(CreateUserdto dto);

    @Mapping(target = "user.id", source = "id")
    public abstract UserOperation mapToOperationById(Long id);

    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "email", source = "user.email")
    public abstract UserResponse mapToResponse(UserOperation operation);
}
