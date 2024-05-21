package com.composite.foreignkey.controller;

import com.composite.foreignkey.model.Airport;
import com.composite.foreignkey.model.Order;
import com.composite.foreignkey.model.OrderDetails;
import com.composite.foreignkey.model.Product;
import com.composite.foreignkey.model_ids.AirportId;
import com.composite.foreignkey.model_ids.OrderDetailID;
import com.composite.foreignkey.repository.OrderDetailsRepository;
import com.composite.foreignkey.repository.OrderRepository;
import com.composite.foreignkey.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("order-details")
@Slf4j
public class OrderDetailsController {

  @Autowired
  private OrderDetailsRepository orderDetailsRepository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private OrderRepository orderRepository;

  @PostMapping("/new")
  public ResponseEntity<OrderDetails> createAirport(@RequestBody OrderDetails orderDetails){
    System.out.println(orderDetails);
    try {
      Product product = orderDetails.getProduct();
      orderDetails.setProduct(productRepository.save(product));

      Order order = orderDetails.getId().getOrder();
      orderDetails.getId().setOrder(orderRepository.save(order));

      OrderDetails airportDao = orderDetailsRepository.save(orderDetails);
      return ResponseEntity.ok(airportDao);
    } catch (Exception e){
      log.error("Error is ", e);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @GetMapping
  public ResponseEntity<List<OrderDetails>> findAllAirport(){
    try {
      List<OrderDetails> airportDao = (List<OrderDetails>) orderDetailsRepository.findAll();
      return ResponseEntity.ok(airportDao);
    } catch (Exception e){
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
  }

  @GetMapping("/get")
  public ResponseEntity<Optional<OrderDetails>> findAirportById(@RequestBody OrderDetailID id){
    try {
      Optional<OrderDetails> airportDao = orderDetailsRepository.findById(id);
      return ResponseEntity.ok(airportDao);
    } catch (Exception e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }
}
