package com.api.java_jato.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.java_jato.models.Customer;

@Repository

public interface CustomerRepository extends JpaRepository<Customer,UUID> {
    
}
