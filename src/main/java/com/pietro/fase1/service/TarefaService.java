package com.pietro.fase1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pietro.fase1.dto.TarefaDTO;
import com.pietro.fase1.repository.TarefaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefaRepository repository;

    public List<TarefaDTO> listarTodas() {
        return repository.findAll().stream()
                .map(t -> new TarefaDTO(t.getId(), t.getDescricao(), t.getConcluida()))
                .toList();
    }

    public Optional<TarefaDTO> buscarPorId(Long id) {
        return repository.findById(id)
                .map(t -> new TarefaDTO(t.getId(), t.getDescricao(), t.getConcluida()));
    }
}
