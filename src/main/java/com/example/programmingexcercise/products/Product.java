package com.example.programmingexcercise.products;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "products")
public class Product {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    // Constructors, getters, and setters
    public Product() {}

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

}
