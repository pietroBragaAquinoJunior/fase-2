package com.pietro.fase1.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pietro.fase1.dto.TarefaDTO;
import com.pietro.fase1.service.TarefaService;
import lombok.RequiredArgsConstructor;

@RestController @RequestMapping("/tarefas") @RequiredArgsConstructor
public class TarefaController {

    private final TarefaService service;

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> listarCompleto(){
        return ResponseEntity.ok(service.listarTodasCompleto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> buscar(@PathVariable Long id){
        return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
}
