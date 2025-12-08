package com.api.java_jato.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.java_jato.dtos.CustomerDTO;
import com.api.java_jato.models.Customer;
import com.api.java_jato.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer create(CustomerDTO dto ){
        Customer customer  = new Customer();
        customer.setEmail(dto.email());
        customer.setNameCustomer(dto.nameCustomer());
        customer.setPhoneNumber(dto.phoneNumber());
        customer.setEmail(dto.email());

        return repository.saveAndFlush(customer);

    }
    
}
