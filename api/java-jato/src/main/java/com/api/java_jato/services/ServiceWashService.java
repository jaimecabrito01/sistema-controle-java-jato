package com.api.java_jato.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.java_jato.dtos.ServiceDTO;
import com.api.java_jato.models.ServiceWash;
import com.api.java_jato.repository.ServiceRepository;

import jakarta.transaction.Transactional;

@Service
public class ServiceWashService {
    @Autowired
    private ServiceRepository repository;

    public ServiceWash create(ServiceDTO dto) {
        ServiceWash service = new ServiceWash();
        service.setCar(dto.getCar());
        service.setServiceType(dto.getServiceType());
        service.setState(dto.getState());
        service.setTotalValue(dto.getTotalValue());
        service.setDataFimServico(dto.getDataFimServico());
        service.setDateEntryQueue(dto.getDateEntryQueue());
        service.setStartDateWashing(dto.getStartDateWashing());

        return repository.saveAndFlush(service);

    }

    @Transactional
    public void alterState(ServiceWash wash) {
        ServiceWash serviceWash = repository.findById(wash.getId())
                .orElseThrow(() -> new RuntimeException("Id not found"));
        serviceWash.setState(wash.getState());
        repository.save(wash);
    }

   

}
