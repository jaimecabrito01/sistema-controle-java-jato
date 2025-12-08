package com.api.java_jato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceType extends JpaRepository<ServiceType,Long> {
    
}
