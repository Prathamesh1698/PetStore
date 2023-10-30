package com.itvedant.petstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.petstore.entities.RegisteredUser;
import com.itvedant.petstore.services.AuthService;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registeredUser(@RequestBody RegisteredUser user) {
        return ResponseEntity.ok(this.authService.register(user));
    }
}
