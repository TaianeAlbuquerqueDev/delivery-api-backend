package com.delivery.backend.entity;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.delivery.backend.DTO.UsuarioDto;
import com.delivery.backend.enums.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cpf;
	@Column(nullable = false)
	private LocalDate dataNasc;
	@Column(nullable = false)
	private String celular;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private LocalDate dataCadastro;

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	@Enumerated(EnumType.STRING)
	private Role role;

	public Usuario() {
		super();
	}

	// evita codigo repetitivo do construtor. ex: this. nome; this.cpf.... busca do
	// entity e passa no dto por este método, trazendo os tipos
	public Usuario(UsuarioDto usuarioDto) {
        BeanUtils.copyProperties(usuarioDto, this);
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(celular, cpf, dataCadastro, dataNasc, email, endereco, id, nome, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(celular, other.celular) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(dataNasc, other.dataNasc)
				&& Objects.equals(email, other.email) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && role == other.role;
	}

}