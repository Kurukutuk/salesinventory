package com.app.salesinventory.model.repository;

import com.app.salesinventory.model.Order;
import com.app.salesinventory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
