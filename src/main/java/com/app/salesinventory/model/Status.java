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
@Entity(name = "status")
public class Status {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(name = "status_id", unique = true, nullable = false, updatable = false)
    private Long id;
    @Column(name = "status_name", nullable = false)
    private String name;
    @OneToOne (mappedBy = "status")
    private Order order;
}
