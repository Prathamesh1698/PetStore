package com.itvedant.petstore.entities;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import validators.Mobile;

@Data
@Entity
// @EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "first name is required")
    @NotEmpty(message = "Name cannot be empty")
    @Column(name = "fname", nullable = false)
    private String firstname;

    @NotEmpty(message = "last name is required")
    @Column(name = "lname", nullable = false)
    private String lastname;

    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email is empty")
    @Email(message = "Email is not well formed")
    @Column(unique = true)
    private String email;

    @Mobile
    private String mobile;
    private String password;

    // @Transient
    // private String confirmpassword;
    @CreatedDate
    private Instant creationTime;

    @LastModifiedDate
    private Instant updationTime;

    @OneToOne
    @JoinColumn(name = "addr_id")
    private Address userAddress;
}
