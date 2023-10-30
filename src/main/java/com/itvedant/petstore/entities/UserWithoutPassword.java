package com.itvedant.petstore.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "userwithoutpassword", types = { User.class })
public interface UserWithoutPassword {
    String getFirstname();

    String getLastname();

    String getEmail();

    String getMobile();
}
