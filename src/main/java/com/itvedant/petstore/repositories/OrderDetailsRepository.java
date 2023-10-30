package com.itvedant.petstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.itvedant.petstore.entities.OrderDetails;

@RestResource(path = "orderDetails")
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

}
