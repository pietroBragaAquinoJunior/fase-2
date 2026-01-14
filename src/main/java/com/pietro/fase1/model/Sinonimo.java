package com.pietro.fase1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// SINONIMO É EXCLUSIVO, NAO EXISTE VÁRIAS PESSOAS APONTANDO PARA UMA PESSOA E SE A PESSOA FOR DELETADA SINONIMO
// DEVE SER DELETADO TAMBÉM.

@Entity
public class Sinonimo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
}