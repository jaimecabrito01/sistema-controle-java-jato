package com.api.java_jato.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.java_jato.models.Customer;
import java.util.List;


@Repository

public interface CustomerRepository extends JpaRepository<Customer,UUID> {
    
    Optional<Customer> findByName(String name);

    
}
