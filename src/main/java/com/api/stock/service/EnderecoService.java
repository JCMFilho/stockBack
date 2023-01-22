package com.api.stock.service;

import java.util.ArrayList;
import java.util.List;

import com.api.stock.entity.Endereco;
import com.api.stock.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.stock.interfaces.IEnderecoService;
import com.api.stock.model.EnderecoDTO;

@Service
public class EnderecoService implements IEnderecoService {

	@Autowired
	EnderecoRepository repository;
	@Override
	public List<Endereco> getEnderecoByUserId(String id) {
		return repository.findAllByidUsuarioId(id);
	}

	@Override
	public Endereco saveEndereco(EnderecoDTO endereco) {
		return repository.saveAndFlush(new Endereco(endereco));
	}

	@Override
	public void deleteEndereco(Integer idEndereco) {
		repository.deleteById(idEndereco);
	}


}
