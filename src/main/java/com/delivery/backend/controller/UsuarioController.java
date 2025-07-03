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

import com.delivery.backend.DTO.UsuarioDto;
import com.delivery.backend.service.UsuarioService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService UsuarioService;

    @GetMapping
    public List<UsuarioDto> listarTodos() {
        return UsuarioService.listarTodos();

    }

    @PostMapping
    public void inserir(@Valid @RequestBody UsuarioDto usuario) {
        UsuarioService.inserir(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> alterar(@PathVariable Long id, @Valid @RequestBody UsuarioDto usuario) {
        usuario.setId(id);
        UsuarioDto atualizado = UsuarioService.alterar(usuario);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        UsuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }
}