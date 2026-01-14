package com.pietro.fase1.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


// SEMPRE DEVEMOS USAR MANY TO ONE, PORÉM SE UMA TABELA É EXCLUSIVA DE OUTRA POR EXEMPLO, 
// O SINONIMO PIETRINHO É EXCLUSIVO DA PESSOA PIETRO, LOGO SE EU DELETAR PIETRO PIETRINHO DEVERÁ SER DELETADO
// ENTAO AO INVÉS DE COLOCAR MANY TO ONE EM PIETRO APONTANDO PARA SINONIMO, EU COLOCO DENTRO DE SINONIMO: ONE TO MANY
// POIS AI ME PERMITE USAR CASCADE DELETE.

@Entity
public class Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    // SINONIMO É EXCLUSIVO, DEVE SER DELETADO AO DELETAR PESSOA POIS NAO EXISTE UM SINONIMO PARA MAIS DE UMA PESSOA
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sinonimo> sinonimos = new ArrayList<>();


    // TIPO SANGUINEO É REUTILIZADO POR VÁRIAS PESSOAS, NAO É EXCLUSIVO, ENTAO SÓ USAMOS MANY TO ONE EM UM LADO,
    //  SEM LIDAR COM LISTA NENHUMA.
    @ManyToOne 
    @JoinColumn(name = "tipo_sanguineo_id")
    private TipoSanguineo tipoSanguineo;
}