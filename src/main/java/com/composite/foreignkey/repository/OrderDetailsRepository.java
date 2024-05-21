package com.composite.foreignkey.repository;

import com.composite.foreignkey.model.OrderDetails;
import com.composite.foreignkey.model_ids.OrderDetailID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetailID> {
}
