package com.api.java_jato.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import com.api.java_jato.states.States;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private States state;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_type_id", nullable = false)
    private ServiceType serviceType;
    @Column(name = "date_entry_queue", nullable = false)
    private LocalDateTime dateEntryQueue;

    @Column(name = "start_date_washing")
    private LocalDateTime startDateWashing;

    @Column(name = "service_end_date")
    private LocalDateTime dataFimServico;
    @Column(name = "total_value")
    private BigDecimal totalValue;

}
