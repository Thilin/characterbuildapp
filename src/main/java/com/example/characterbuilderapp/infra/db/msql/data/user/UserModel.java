package com.example.characterbuilderapp.infra.db.msql.data.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user")
@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    private Long id;

    @Column(name = "USR_NAME")
    private String name;

    @Column(name = "USR_NICKNAME")
    private String username;

    @Column(name = "USR_EMAIl")
    private String email;

    @Column(name = "USR_PASSWORD")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_user_profile",
            joinColumns = @JoinColumn(name = "UPR_USR_ID"),
            inverseJoinColumns = @JoinColumn(name = "UPR_PRO_ID")
    )
    private List<ProfileModel> profile = new ArrayList<>();
}
