package com.itvedant.petstore.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "userwithaddr", types = { User.class })
public interface UserWithAddress {
    // @Value("#{target.firstName}")
    // String getFName();

    // @Value("#{target.lastName}")
    // String getLName();

    @Value("#{target.firstName + ' ' + target.lastName}")
    String getName();

    @Value("#{target.userAddress.city}")
    String getCity();

    @Value("#{target.userAddress.state}")
    String getState();

    @Value("#{target.userAddress.country}")
    String getCountry();
}
