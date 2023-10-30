package com.itvedant.petstore.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.petstore.entities.User;
import com.itvedant.petstore.repositories.UserRepository;

@Service
public class UserService {

    // @Autowired
    // private UserRepository repository;

    // // private Map<Integer, User> userMap = new HashMap<>();
    // // private AtomicInteger atomic = new AtomicInteger();

    // public User addUser(User newUser) {
    //     // newuser.setId(atomic.incrementAndGet());
    //     // userMap.put(newuser.getId(), newuser);
    //     // return newuser;
    //     return repository.save(newUser);
    // }

    // public Iterable<User> getAllUser() {
    //     // return userMap.values();
    //     return repository.findAll();
    // }

    // public User getUserById(Integer Id) {
    //     // return userMap.get(Id);
    //     return repository.findById(Id).orElse(null);
    // }

    // public User updateUser(Integer id, User updatedUser) {
    //     // updatedUser.setId(id);
    //     // userMap.put(id, updatedUser);
    //     // return updatedUser;
    //     updatedUser.setId(id);
    //     return repository.save(updatedUser);
    // }

    // public String deleteUser(Integer id) {
    //     // userMap.remove(id);
    //     repository.deleteById(id);
    //     return "User deleted successfully.";
    // }
}
