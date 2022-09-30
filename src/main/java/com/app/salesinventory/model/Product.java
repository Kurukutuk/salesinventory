package com.app.salesinventory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(name = "product_id", unique = true, nullable = false, updatable = false)
    private Long id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "selling_price")
    private Double price;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;
}
