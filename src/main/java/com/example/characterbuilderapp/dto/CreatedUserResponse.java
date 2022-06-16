package com.example.characterbuilderapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CreatedUserResponse {

    private Long id;
    private String name;
    private String username;
    private String email;
}
