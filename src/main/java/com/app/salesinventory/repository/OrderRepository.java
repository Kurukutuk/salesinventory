package com.app.salesinventory.repository;

import com.app.salesinventory.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findOrderById(Long id);

    void deleteOrderById(Long id);
}
