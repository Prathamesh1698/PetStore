package com.itvedant.petstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.itvedant.petstore.entities.Product;

import jakarta.annotation.security.RolesAllowed;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByPrice(Double price);

    @Secured("ROLE_SALES")
    @RestResource(path = "greater")
    List<Product> findByPriceGreaterThan(Double price);

    @RolesAllowed("IT")
    @RestResource(path = "less")
    List<Product> findByPriceLessThan(Double price);

    @PreAuthorize("hasRole('HR')")
    List<Product> findByPriceBetween(Double low, Double high);

}
