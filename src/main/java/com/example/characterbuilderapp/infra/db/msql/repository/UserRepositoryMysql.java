package com.example.characterbuilderapp.infra.db.msql.repository;

import com.example.characterbuilderapp.infra.db.msql.data.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryMysql extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByEmail(String email);

    boolean existsByEmail(String email);
}
