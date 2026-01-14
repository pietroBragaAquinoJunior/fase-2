package com.pietro.fase1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pietro.fase1.model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    // Trazer tudo de uma só vez, evitando problema N+1, pois eu quero a informação da categoria.
    @Query("SELECT t FROM Tarefa t JOIN FETCH t.categoria")
    List<Tarefa> findAllCompletas();

    @Query("SELECT t FROM Tarefa t JOIN FETCH t.categoria WHERE t.id = :id")
    Optional<Tarefa> findByIdCompleto(@Param("id") Long id);
}
