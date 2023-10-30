package com.itvedant.petstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.itvedant.petstore.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    
}
