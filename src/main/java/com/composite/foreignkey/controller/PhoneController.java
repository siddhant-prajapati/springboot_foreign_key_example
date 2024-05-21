package com.composite.foreignkey.controller;

import com.composite.foreignkey.model.Phone;
import com.composite.foreignkey.model_ids.PhoneId;
import com.composite.foreignkey.repository.PhoneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("phone")
@Slf4j
public class PhoneController {

  @Autowired
  private PhoneRepository phoneRepository;

  @PostMapping("/new")
  public ResponseEntity<Phone> createAirport(@RequestBody Phone phone){
    log.info(String.valueOf(phone));
    try {
      Phone phoneDao = phoneRepository.save(phone);
      return ResponseEntity.ok(phoneDao);
    } catch (Exception e){
      log.error("Error is : ",e);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @GetMapping
  public ResponseEntity<List<Phone>> findAllAirport(){
    try {
      List<Phone> airportDao = (List<Phone>) phoneRepository.findAll();
      return ResponseEntity.ok(airportDao);
    } catch (Exception e){
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
  }

  @GetMapping("/get")
  public ResponseEntity<Optional<Phone>> findAirportById(@RequestBody PhoneId id){
    try {
      Optional<Phone> airportDao = phoneRepository.findById(id);
      return ResponseEntity.ok(airportDao);
    } catch (Exception e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }
}
