package com.delivery.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.backend.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
