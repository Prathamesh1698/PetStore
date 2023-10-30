package com.itvedant.petstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.itvedant.petstore.entities.RegisteredUser;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUser ,Integer>{
    
    //Disallow the direct call to the save method
    //Means the post request is  disabled
    @RestResource(exported = false)
    <S extends RegisteredUser> S save(S entity);

    RegisteredUser findByEmail(String email);
}
