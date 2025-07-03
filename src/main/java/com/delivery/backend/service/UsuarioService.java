package com.delivery.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.backend.DTO.UsuarioDto;
import com.delivery.backend.entity.Usuario;
import com.delivery.backend.repository.UsuarioRepository;


@Service
public class UsuarioService {

    @Autowired
    public UsuarioRepository usuarioRepository;

    public List<UsuarioDto> listarTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDto::new).toList();

    }

    public void inserir(UsuarioDto usuario) {
        Usuario usuarioEntity = new Usuario(usuario);
        usuarioRepository.save(usuarioEntity);

    }

    public UsuarioDto alterar(UsuarioDto usuario) {
        Usuario usuarioEntity = new Usuario(usuario);
        return new UsuarioDto(usuarioRepository.save(usuarioEntity));
    }

    public void excluir(Long id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }

    public UsuarioDto buscarPorId(Long id) {
        return new UsuarioDto(usuarioRepository.findById(id).get());
    }

}