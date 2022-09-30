package com.app.salesinventory.model.repository;

import com.app.salesinventory.model.Order;
import com.app.salesinventory.model.Stock;
import com.app.salesinventory.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Long> {

    Optional<Stock> findTypeById(Long id);

    void deleteTypeById(Long id);
}
