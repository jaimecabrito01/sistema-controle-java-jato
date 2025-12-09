package com.api.java_jato.dtos;

import java.math.BigDecimal;

public record ServiceCreateDTO(Long carId, Long idServiceType,BigDecimal totalValue) {
    
}
