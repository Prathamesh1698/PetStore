package com.itvedant.petstore.entities;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String city;
    private String state;
    private String country;

    @CreatedDate
    private Instant creationTime;

    @LastModifiedDate
    private Instant updationTime;
    
    @OneToOne(mappedBy = "userAddress")
    private User user;
}
