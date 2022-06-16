package com.example.characterbuilderapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateUserdto {
    private String name;
    private String username;
    private String email;
    private String password;
}
