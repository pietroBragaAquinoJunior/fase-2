package com.pietro.fase1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pietro.fase1.dto.TarefaDTO;
import com.pietro.fase1.model.Tarefa;
import com.pietro.fase1.repository.TarefaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefaRepository repository;

    public List<TarefaDTO> listarTodasCompleto() {
        return repository.findAllCompletas().stream()
                .map(t -> new TarefaDTO(t.getId(), t.getDescricao(), t.getConcluida(), t.getCategoria().getNome()))
                .toList();
    }

    public Optional<TarefaDTO> buscarPorId(Long id) {
        return repository.findByIdCompleto(id)
                .map(t -> new TarefaDTO(t.getId(), t.getDescricao(), t.getConcluida(), t.getCategoria().getNome()));
    }

    // Usando transactional. Ou tudo acontece, ou nada acontece.
    @Transactional
    public void concluirTarefa(Long id){
        Tarefa tarefa = repository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada."));
        tarefa.setConcluida(true);
        repository.save(tarefa);
    }
}
