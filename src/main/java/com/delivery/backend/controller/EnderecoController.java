package com.delivery.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.backend.DTO.EnderecoDto;
import com.delivery.backend.service.EnderecoService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService EnderecoService;

    @GetMapping
    public List<EnderecoDto> listarTodos() {
        return EnderecoService.listarTodos();

    }

    @PostMapping
    public void inserir(@Valid @RequestBody EnderecoDto endereco) {
        EnderecoService.inserir(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDto> alterar(@PathVariable Long id, @Valid @RequestBody EnderecoDto endereco) {
        endereco.setId(id);
        EnderecoDto atualizado = EnderecoService.alterar(endereco);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        EnderecoService.excluir(id);
        return ResponseEntity.ok().build();
    }

}