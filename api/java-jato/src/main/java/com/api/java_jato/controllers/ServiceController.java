package com.api.java_jato.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.java_jato.dtos.ServiceCreateDTO;
import com.api.java_jato.dtos.ServiceDTO;
import com.api.java_jato.models.ServiceWash;
import com.api.java_jato.repository.CarRepository;
import com.api.java_jato.repository.ServiceRepository;
import com.api.java_jato.repository.ServiceTypeRepository;
import com.api.java_jato.services.ServiceWashService;
import com.api.java_jato.services.StateMachineService;
import com.api.java_jato.states.States;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1")
public class ServiceController {

    @Autowired
    private ServiceWashService service;
    private CarRepository repository;
    private ServiceTypeRepository typeRepository;
    private StateMachineService state;
    
    @PostMapping("/service/new")
    public ResponseEntity<ServiceWash> create(@RequestBody  ServiceCreateDTO dto) {
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setCar(repository.getById(dto.carId()));
        serviceDTO.setDateEntryQueue(LocalDateTime.now());
        serviceDTO.setServiceType(typeRepository.getById(dto.idServiceType()));
        
        state.newQueue();
        return ResponseEntity.ok().body(service.create(serviceDTO));
            
    }
    
    
}
