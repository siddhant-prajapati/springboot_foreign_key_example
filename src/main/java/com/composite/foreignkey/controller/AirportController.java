package com.composite.foreignkey.controller;

import com.composite.foreignkey.model.Airport;
import com.composite.foreignkey.model_ids.AirportId;
import com.composite.foreignkey.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("airport")
public class AirportController {
  @Autowired
  private AirportRepository airportRepository;

  @PostMapping("/new")
  public ResponseEntity<Airport> createAirport(@RequestBody Airport airport){
    try {
      Airport airportDao = airportRepository.save(airport);
      return ResponseEntity.ok(airportDao);
    } catch (Exception e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @GetMapping
  public ResponseEntity<List<Airport>> findAllAirport(){
    try {
      List<Airport> airportDao = (List<Airport>) airportRepository.findAll();
      return ResponseEntity.ok(airportDao);
    } catch (Exception e){
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
  }

  @GetMapping("/get")
  public ResponseEntity<Optional<Airport>> findAirportById(@RequestBody AirportId id){
    try {
      Optional<Airport> airportDao = airportRepository.findById(id);
      return ResponseEntity.ok(airportDao);
    } catch (Exception e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }
}
