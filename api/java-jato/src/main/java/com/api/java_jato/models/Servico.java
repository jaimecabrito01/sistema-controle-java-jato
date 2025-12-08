package com.api.java_jato.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.hibernate.annotations.Collate;

import com.api.java_jato.states.Estados;

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
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private Estados estado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carro_id", nullable = false)
    private Carro carro;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_servico_id", nullable = false)
    private TipoServico tipoServico;
    @Column(name = "data_entrada_fila", nullable = false)
    private LocalDateTime dataEntradaFila;

    @Column(name = "data_inicio_lavagem")
    private LocalDateTime dataInicioLavagem;

    @Column(name = "data_fim_servico")
    private LocalDateTime dataFimServico;
    private BigDecimal valor_total;

}
