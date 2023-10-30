package com.itvedant.petstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.petstore.entities.User;
import com.itvedant.petstore.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

    // @Autowired
    // private UserService userService;

    // @PostMapping("/users")
    // public ResponseEntity<?> add(@RequestBody @Valid User u) {
    //     return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(u));
    // }

    // @GetMapping("/users")
    // public ResponseEntity<?> getUsers() {
    //     return ResponseEntity.ok().body(userService.getAllUser());

    // }

    // @GetMapping("/users/{id}")
    // public ResponseEntity<?> getUser(@PathVariable Integer id) {
    //     User found = userService.getUserById(id);
    //     if (found == null) {
    //         return ResponseEntity.badRequest().body("User with this ID does not exists.");
    //     } else {
    //         return ResponseEntity.ok().body(found);
    //     }

    // }

    // @PutMapping("/users/{id}")
    // public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody User u) {
    //     User found = userService.getUserById(id);
    //     if (found == null) {
    //         return ResponseEntity.badRequest().body("User with this ID does not exists.");
    //     } else {
    //         return ResponseEntity.ok().body(userService.updateUser(id, u));
    //     }
    // }

    // @DeleteMapping("/users/{id}")
    // public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
    //     User found = userService.getUserById(id);
    //     if (found == null) {
    //         return ResponseEntity.badRequest().body("User with this ID does not exists.");
    //     } else {
    //         return ResponseEntity.ok().body(userService.deleteUser(id));
    //     }
    // }
}
