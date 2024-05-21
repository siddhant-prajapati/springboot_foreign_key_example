package com.composite.foreignkey.controller;

import com.composite.foreignkey.model.Airport;
import com.composite.foreignkey.model.Order;
import com.composite.foreignkey.model_ids.AirportId;
import com.composite.foreignkey.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("order")
public class OrderController {

  @Autowired
  private OrderRepository orderRepository;

  @PostMapping("/new")
  public ResponseEntity<Order> createAirport(@RequestBody Order order){
    try {
      Order airportDao = orderRepository.save(order);
      return ResponseEntity.ok(airportDao);
    } catch (Exception e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @GetMapping
  public ResponseEntity<List<Order>> findAllAirport(){
    try {
      List<Order> airportDao = (List<Order>) orderRepository.findAll();
      return ResponseEntity.ok(airportDao);
    } catch (Exception e){
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<Optional<Order>> findAirportById(@PathVariable("id") Integer id){
    try {
      Optional<Order> airportDao = orderRepository.findById(id);
      return ResponseEntity.ok(airportDao);
    } catch (Exception e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }
}
