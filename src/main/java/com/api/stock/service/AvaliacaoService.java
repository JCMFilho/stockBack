package com.api.stock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.stock.interfaces.IAvaliacaoService;
import com.api.stock.model.AvaliacaoDTO;

@Service
public class AvaliacaoService implements IAvaliacaoService {

	@Override
	public List<AvaliacaoDTO> getAvaliacao() {
		List<AvaliacaoDTO> avaliacoes = new ArrayList<>();
		AvaliacaoDTO avaliacao = new AvaliacaoDTO();
		avaliacao.setId(1);
		avaliacao.setNome("Sarah");
		avaliacao.setTitulo("Muito bom");
		avaliacao.setDescricao("Gostei muito do produto, compraria novamente");
		avaliacao.setNota(5);
		avaliacao.setData("15/05/2022");
		avaliacoes.add(avaliacao);
		avaliacao = new AvaliacaoDTO();
		avaliacao.setId(2);
		avaliacao.setNome("Ana");
		avaliacao.setTitulo("Mediano");
		avaliacao.setDescricao("Achei o produto muito pequeno para o valor");
		avaliacao.setNota(3);
		avaliacao.setData("01/01/2001");
		avaliacoes.add(avaliacao);
		return avaliacoes;
	}
	
}
