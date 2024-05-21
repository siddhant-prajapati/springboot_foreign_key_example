package com.composite.foreignkey.repository;

import com.composite.foreignkey.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
