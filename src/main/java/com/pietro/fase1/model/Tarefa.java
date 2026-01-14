package com.pietro.fase1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Boolean concluida;

    // USAMOS SOMENTE MANY TO ONE POIS NAO PRECISAMOS DE LISTA PARA UMA ENTIDADE AUXILIAR QUE NÃO É EXCLUSIVA, OLHAR
    // ENTIDADES: PESSOA ~ SINONIMO E PESSOA ~ TIPO SANGUINEO.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
