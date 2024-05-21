package com.composite.foreignkey.repository;

import com.composite.foreignkey.model.Phone;
import com.composite.foreignkey.model_ids.PhoneId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, PhoneId> {
}
