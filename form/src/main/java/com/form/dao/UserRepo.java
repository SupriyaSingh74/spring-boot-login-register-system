package com.form.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.form.entities.User;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
