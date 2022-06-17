package com.example.characterbuilderapp.mapper;

import com.example.characterbuilderapp.core.operations.job.JobOperation;
import com.example.characterbuilderapp.domain.job.Job;
import com.example.characterbuilderapp.dto.JobResponse;
import com.example.characterbuilderapp.infra.db.msql.data.job.JobModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class JobMapper {

    public static final JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);

    public abstract Job mapToDomain(JobModel model);

    @Mapping(target = "job.id", source = "id")
    public abstract JobOperation mapToOperation(Long id);

    @Mapping(target = "id", source = "job.id")
    @Mapping(target = "description", source = "job.description")
    @Mapping(target = "image", source = "job.image")
    public abstract JobResponse mapToResponse(JobOperation operation);
}
