package com.app.salesinventory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity (name = "stocks")
public class Stock {
    @Id
    @SequenceGenerator(
            name = "stock_sequence",
            sequenceName = "stock_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stock_sequence"
    )
    @Column(name = "stock_id", unique = true, nullable = false, updatable = false)
    private Long id;
    @Column(name = "stock_name", nullable = false)
    private Long typeId;
    @Column(name = "qty")
    private Integer quantity;
    @Column(name = "stock_price")
    private Double price;
    @Column(name = "date_added")
    private Date dateAdded;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "type_id")
    private Type type;
}
