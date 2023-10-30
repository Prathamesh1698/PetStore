package com.itvedant.petstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.itvedant.petstore.entities.User;
import com.itvedant.petstore.entities.UserWithoutPassword;

@RepositoryRestResource(excerptProjection = UserWithoutPassword.class)
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByFirstname(String name);

    User findByEmail(String email);

    List<User> findByEmailContaining(String pattern);
}
