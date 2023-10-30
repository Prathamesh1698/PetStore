package com.itvedant.petstore.entities;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDate localDate;

    private Double totalAmt;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Instant creationTime;

    @LastModifiedDate
    private Instant updationTime;

    @ManyToMany(mappedBy = "orders")
    private List<Product> productsOrdered;
}