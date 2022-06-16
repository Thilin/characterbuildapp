package com.example.characterbuilderapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisionCardsBuildRequest {

    private Long id;
    private boolean isMain;
}
