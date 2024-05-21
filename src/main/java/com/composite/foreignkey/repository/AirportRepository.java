package com.composite.foreignkey.repository;

import com.composite.foreignkey.model.Airport;
import com.composite.foreignkey.model_ids.AirportId;
import org.springframework.data.repository.CrudRepository;

public interface AirportRepository extends CrudRepository<Airport, AirportId> {
}
