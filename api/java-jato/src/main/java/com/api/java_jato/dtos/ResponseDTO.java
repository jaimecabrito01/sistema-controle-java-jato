package com.api.java_jato.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.api.java_jato.models.Car;
import com.api.java_jato.models.ServiceType;
import com.api.java_jato.states.States;

public record ResponseDTO(States state, Car car, ServiceType serviceType, LocalDateTime dateEntryQueue,
        LocalDateTime startDateWashing, LocalDateTime dataFimServico, BigDecimal totalValue) {

}
