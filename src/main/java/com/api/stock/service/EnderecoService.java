package com.api.stock.service;

import com.api.stock.entity.Endereco;
import com.api.stock.interfaces.IEnderecoService;
import com.api.stock.model.EnderecoDTO;
import com.api.stock.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
		Endereco end = repository.saveAndFlush(new Endereco(endereco));
		definirEnderecoPrincipal(end.getId());
		return end;
	}

	@Override
	public void deleteEndereco(Integer idEndereco) {
		repository.deleteById(idEndereco);
	}

	@Override
	public void definirEnderecoPrincipal(Integer idEndereco) {
		Endereco endereco = repository.findById(idEndereco).orElse(new Endereco());
		List<Endereco> enderecos = repository.findAllByidUsuarioIdAndEnderecoPrincipal(endereco.getIdUsuario().getId(), true);
		if(enderecos != null && enderecos.size() > 0){
			enderecos.forEach(end -> end.setEnderecoPrincipal(false));
			repository.saveAllAndFlush(enderecos);
		}
		endereco.setEnderecoPrincipal(true);
		repository.saveAndFlush(endereco);

	}

	@Override
	public Endereco buscarEnderecoPrincipal(String idUsuario) {
		return repository.findAllByidUsuarioIdAndEnderecoPrincipal(idUsuario, true).get(0);
	}


}
