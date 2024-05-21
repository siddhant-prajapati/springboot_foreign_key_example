package com.composite.foreignkey.repository;

import com.composite.foreignkey.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
