package com.app.salesinventory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "types")
public class Type {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(name = "type_id", unique = true, nullable = false, updatable = false)
    private Long id;
    @Column(name = "type_name", nullable = false)
    private String name;
    @OneToOne (mappedBy = "type")
    private Stock stock;
}
