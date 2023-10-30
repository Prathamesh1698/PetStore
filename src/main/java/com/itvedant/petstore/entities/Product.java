package com.itvedant.petstore.entities;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.Length;
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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "Name should not be empty")
    @NotEmpty(message = "Field should contain some characters")
    @Length(min = 3, max = 20, message = "Name should be 3 to 20 chars")
    // @Column(name = "pname" ,nullable = false)
    private String name;

    @NotNull(message = "price should not be empty")
    @Min(value = 1)
    @Max(value = 10000)
    // @Column(name = "Price" , nullable = false)
    private Double price;

    @NotNull(message = "Desc should not be empty")
    @NotEmpty
    @Length(min = 3, max = 20, message = "Desc should be 3 to 20 chars")
    // @Column(name = "Desc", nullable = false)
    private String description;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Instant creationTime;

    @LastModifiedDate
    private Instant updationTime;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany
    @JoinTable(name = "Product_orders", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<OrderDetails> orders;

    private String imageUrl;
}
