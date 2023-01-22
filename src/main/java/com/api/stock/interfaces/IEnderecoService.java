package com.api.stock.interfaces;

import java.util.List;

import com.api.stock.entity.Endereco;
import com.api.stock.model.EnderecoDTO;

public interface IEnderecoService {

	List<Endereco> getEnderecoByUserId(String id);

	Endereco saveEndereco(EnderecoDTO endereco);

	void deleteEndereco(Integer idEndereco);
	
}
