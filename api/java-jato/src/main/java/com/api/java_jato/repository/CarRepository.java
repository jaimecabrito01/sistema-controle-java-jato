package com.api.java_jato.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.java_jato.models.Car;
import java.util.List;


@Repository
public interface CarRepository  extends JpaRepository<Car,Long>{
    Optional<Car> findByLicensePlate(String licensePlate);
    
}
