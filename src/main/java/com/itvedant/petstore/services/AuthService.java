package com.itvedant.petstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.itvedant.petstore.entities.RegisteredUser;
import com.itvedant.petstore.repositories.RegisteredUserRepository;

@Service
public class AuthService {

    @Autowired
    private RegisteredUserRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String register(RegisteredUser user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        this.repository.save(user);
        return "User registered successfully";
    }
}
