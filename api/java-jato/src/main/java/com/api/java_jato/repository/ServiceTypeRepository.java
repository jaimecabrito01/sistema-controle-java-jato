package com.api.java_jato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.java_jato.models.ServiceType;
@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType,Long> {
    
}
