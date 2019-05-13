package com.techprimers.security.springsecurityauthserver.UsersRepository;

import com.techprimers.security.springsecurityauthserver.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Integer> {
    Optional<Users> findByName(String username);

    Users findUsersByEmail(String email);
}
