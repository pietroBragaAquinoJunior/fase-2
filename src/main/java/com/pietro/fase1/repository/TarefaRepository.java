package com.pietro.fase1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pietro.fase1.model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {}
