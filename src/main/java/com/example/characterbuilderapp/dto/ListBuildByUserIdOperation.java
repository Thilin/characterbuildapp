package com.example.characterbuilderapp.dto;

import com.example.characterbuilderapp.domain.build.Build;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ListBuildByUserIdOperation {

    private Long userId;
    private List<Build> build;
}
