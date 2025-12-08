package com.api.java_jato.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.api.java_jato.models.Car;
import com.api.java_jato.models.ServiceType;
import com.api.java_jato.states.States;



public class ServiceDTO {

    private States state;
    private Car car;
    private ServiceType serviceType;
    private LocalDateTime dateEntryQueue;

    private LocalDateTime startDateWashing;

    private LocalDateTime dataFimServico;
  
    private BigDecimal totalValue;

    

    public ServiceDTO(States state, Car car, ServiceType serviceType, LocalDateTime dateEntryQueue,
            LocalDateTime startDateWashing, LocalDateTime dataFimServico, BigDecimal totalValue) {
        this.state = state;
        this.car = car;
        this.serviceType = serviceType;
        this.dateEntryQueue = dateEntryQueue;
        this.startDateWashing = startDateWashing;
        this.dataFimServico = dataFimServico;
        this.totalValue = totalValue;
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public LocalDateTime getDateEntryQueue() {
        return dateEntryQueue;
    }

    public void setDateEntryQueue(LocalDateTime dateEntryQueue) {
        this.dateEntryQueue = dateEntryQueue;
    }

    public LocalDateTime getStartDateWashing() {
        return startDateWashing;
    }

    public void setStartDateWashing(LocalDateTime startDateWashing) {
        this.startDateWashing = startDateWashing;
    }

    public LocalDateTime getDataFimServico() {
        return dataFimServico;
    }

    public void setDataFimServico(LocalDateTime dataFimServico) {
        this.dataFimServico = dataFimServico;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    } 

    

}
