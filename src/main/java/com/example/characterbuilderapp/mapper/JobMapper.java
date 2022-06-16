package com.example.characterbuilderapp.mapper;

import com.example.characterbuilderapp.infra.db.msql.data.job.JobModel;
import com.example.characterbuilderapp.dto.JobResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class JobMapper {

    public static final JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);

    public abstract JobResponse mapToDTO(JobModel job);
}
