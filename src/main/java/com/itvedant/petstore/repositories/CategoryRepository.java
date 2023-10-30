package com.itvedant.petstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.itvedant.petstore.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
