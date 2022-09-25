package com.example.characterbuilderapp.core.mapper;

import com.example.characterbuilderapp.core.operations.build.CreateBuildOperation;
import com.example.characterbuilderapp.core.operations.build.ListResumedBuildOperation;
import com.example.characterbuilderapp.domain.build.Build;
import com.example.characterbuilderapp.dto.CreateBuildDTO;
import com.example.characterbuilderapp.dto.ListResumedBuildResponse;
import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class BuildMapper {

    public static final BuildMapper INSTANCE = Mappers.getMapper(BuildMapper.class);

    public abstract CharacterBuiltModel mapToModel(Build build);

    public abstract CreateBuildOperation mapToOperation(CreateBuildDTO dto);

    public abstract Build mapToDomain(CharacterBuiltModel buildModel);

    public abstract ListResumedBuildResponse mapToResponse(ListResumedBuildOperation operation);

}
