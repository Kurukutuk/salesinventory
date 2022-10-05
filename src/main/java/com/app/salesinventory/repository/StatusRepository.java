package com.app.salesinventory.repository;

import com.app.salesinventory.model.Order;
import com.app.salesinventory.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Long> {

    Optional<Status> findStatusById(Long id);

    void deleteStatusById(Long id);
}
