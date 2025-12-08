package com.api.java_jato.models;

import java.util.UUID;

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
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor  
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private UUID Id;
    @Column(name = "nome_completo")
    private String nome_completo;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "email")
    private String email;
    





}
