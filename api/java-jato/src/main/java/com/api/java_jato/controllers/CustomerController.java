package com.api.java_jato.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.java_jato.dtos.CustomerDTO;
import com.api.java_jato.models.Customer;
import com.api.java_jato.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired  private CustomerService service;
    
    @PostMapping("/customer/new")
    public ResponseEntity<String> create(@RequestBody CustomerDTO dto) {

        try {
            return ResponseEntity.ok().body(service.create(dto).toString());
        } catch (Exception e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
        
    }
    
}
