package com.api.java_jato.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipo_servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome",unique = true)
    private String nome;
    @Column(name = "preco")
    private BigDecimal preco;
    @Column(name = "tempo_estimado_minutos")
    private int tempo_estimado_minutos;
    
    


    
    
}
