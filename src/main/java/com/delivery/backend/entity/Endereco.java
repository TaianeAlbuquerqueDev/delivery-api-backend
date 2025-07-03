package com.delivery.backend.entity;

import org.springframework.beans.BeanUtils;

import com.delivery.backend.DTO.EnderecoDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String rua;
	@Column(nullable = false)
	private Integer numero;
	@Column(nullable = false)
	private String pontoReferencia;
	@Column(nullable = false)
	private String bairro;
	@Column(nullable = false)
	private String cep;
	
	public Endereco() {
		super();
	}
	// evita codigo repetitivo do construtor. ex: this. nome; this.cpf.... busca do
	// entity e passa no dto por este método, trazendo os tipos
	public Endereco(EnderecoDto enderecoDto) {
		BeanUtils.copyProperties(enderecoDto, this);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getPontoReferencia() {
		return pontoReferencia;
	}
	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}