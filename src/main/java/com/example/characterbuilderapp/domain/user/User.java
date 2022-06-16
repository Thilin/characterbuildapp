package com.example.characterbuilderapp.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private List<Profile> profiles;
}
