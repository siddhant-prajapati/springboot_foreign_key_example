package com.composite.foreignkey.controller;

import com.composite.foreignkey.model.Airport;
import com.composite.foreignkey.model.Product;
import com.composite.foreignkey.model_ids.AirportId;
import com.composite.foreignkey.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @PostMapping("/new")
  public ResponseEntity<Product> create(@RequestBody Product product){
    try {
      Product airportDao = productRepository.save(product);
      return ResponseEntity.ok(airportDao);
    } catch (Exception e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @GetMapping
  public ResponseEntity<List<Product>> findAll(){
    try {
      List<Product> airportDao = (List<Product>) productRepository.findAll();
      return ResponseEntity.ok(airportDao);
    } catch (Exception e){
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<Optional<Product>> findById(@PathVariable("id") int id){
    try {
      Optional<Product> airportDao = productRepository.findById(id);
      return ResponseEntity.ok(airportDao);
    } catch (Exception e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }
}
