package com.api.java_jato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.java_jato.models.ServiceWash;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceWash,Long>{
    
    
}
