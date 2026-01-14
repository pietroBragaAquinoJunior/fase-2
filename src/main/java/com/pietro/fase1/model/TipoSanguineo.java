package com.pietro.fase1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


// TIPO SANGUINEO NAO É EXCLUSIVO, MAS DE UMA PESSOA PODE TER O MESMO TIPO SANGUINEO, LOGO APENAS MANY TO ONE DE UM LADO
// E JAMAIS CASCADE.
@Entity
public class TipoSanguineo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao; // "A+", "O-", etc.
}