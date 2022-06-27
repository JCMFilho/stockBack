package com.api.stock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.stock.interfaces.IEnderecoService;
import com.api.stock.model.EnderecoDTO;

@Service
public class EnderecoService implements IEnderecoService {
	
	@Override
	public List<EnderecoDTO> getEndereco() {
		List<EnderecoDTO> enderecos = new ArrayList<>();
		EnderecoDTO endereco = new EnderecoDTO();
		endereco.setId(1);
		endereco.setTipo("Rua");
		endereco.setLogradouro("Maura");
		endereco.setNumero("540");
		endereco.setBairro("Boa Vista");
		endereco.setCidade("Belo Horizonte");
		endereco.setEstado("Minas Gerais");
		endereco.setCep("31.111-111");
		enderecos.add(endereco);
		endereco = new EnderecoDTO();
		endereco.setId(2);
		endereco.setTipo("Avenida");
		endereco.setLogradouro("Amazonas");
		endereco.setNumero("1234");
		endereco.setBairro("Centro");
		endereco.setCidade("Belo Horizonte");
		endereco.setEstado("Minas Gerais");
		endereco.setCep("31.111-111");
		enderecos.add(endereco);
		return enderecos;
	}

}
