package com.api.java_jato.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.java_jato.dtos.CarDTO;
import com.api.java_jato.models.Car;
import com.api.java_jato.repository.CarRepository;

@Service
public class CarService {
    @Autowired
    private CarRepository repository;

    public Car create (CarDTO car){
        Car c = new Car();

        c.setLicensePlate(car.licensePlate());
        c.setColor(car.color());
        c.setCustomer_id(car.customer());
        c.setModel(car.model());
        
        return repository.saveAndFlush(c);
        
    }

    
    
}
