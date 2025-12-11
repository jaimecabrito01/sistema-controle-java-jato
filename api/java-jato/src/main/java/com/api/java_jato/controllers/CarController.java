package com.api.java_jato.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.java_jato.dtos.CarDTO;
import com.api.java_jato.models.Car;
import com.api.java_jato.services.CarService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1")
public class CarController {
    @Autowired
    private CarService service;

    @PostMapping("/car/new")
    public ResponseEntity<Car> create(@RequestBody CarDTO dto) {        
        return ResponseEntity.ok().body(service.create(dto));
    }

    
    
    
}
