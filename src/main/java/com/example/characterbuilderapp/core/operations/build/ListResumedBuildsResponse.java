package com.example.characterbuilderapp.core.operations.build;

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
public class ListResumedBuildsResponse {

    private Long userId;
    private List<Build> builds;
}
