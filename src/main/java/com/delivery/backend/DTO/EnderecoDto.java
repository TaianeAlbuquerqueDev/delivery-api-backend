package com.delivery.backend.DTO;

import org.springframework.beans.BeanUtils;

import com.delivery.backend.entity.Endereco;

public class EnderecoDto {
	
	private Long id;
	private String rua;
	private Integer numero;
	private String pontoReferencia;
	private String bairro;
	private String cep;
	
	
	public EnderecoDto() {
		super();
	}
	
	public EnderecoDto(Endereco endereco) {
		BeanUtils.copyProperties(endereco, this);
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

