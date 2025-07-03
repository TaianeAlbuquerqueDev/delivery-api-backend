package com.delivery.backend.DTO;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.BeanUtils;

import com.delivery.backend.entity.Usuario;

import jakarta.validation.constraints.Email;

public class UsuarioDto {

	private Long id;
	private String nome;
	@CPF
	private String cpf;
	private LocalDate dataNasc;
	private String celular;
	@Email
	private String email;
	private LocalDate dataCadastro;
	
	
	public UsuarioDto() {
		super();
	}
	//evita codigo repetitivo do construtor. ex: this. nome; this.cpf.... busca do entity e passa no dto por este método, trazendo os tipos
	public UsuarioDto(Usuario usuario) {
        BeanUtils.copyProperties(usuario, this);
    }
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}