package com.delivery.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.backend.DTO.EnderecoDto;
import com.delivery.backend.entity.Endereco;
import com.delivery.backend.repository.EnderecoRepository;


@Service
public class EnderecoService {

    @Autowired
    public EnderecoRepository enderecoRepository;

    public List<EnderecoDto> listarTodos() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos.stream().map(EnderecoDto::new).toList();

    }

    public void inserir(EnderecoDto endereco) {
        Endereco enderecoEntity = new Endereco(endereco);
        enderecoRepository.save(enderecoEntity);

    }

    public EnderecoDto alterar(EnderecoDto endereco) {
        Endereco enderecoEntity = new Endereco(endereco);
        return new EnderecoDto(enderecoRepository.save(enderecoEntity));
    }

    public void excluir(Long id) {
        Endereco endereco = enderecoRepository.findById(id).get();
        enderecoRepository.delete(endereco);
    }

    public EnderecoDto buscarPorId(Long id) {
        return new EnderecoDto(enderecoRepository.findById(id).get());
    }

}