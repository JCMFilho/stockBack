package com.api.stock.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.api.stock.entity.Avaliacao;
import com.api.stock.entity.Produto;
import com.api.stock.entity.Usuario;
import com.api.stock.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.stock.interfaces.IAvaliacaoService;
import com.api.stock.model.AvaliacaoDTO;

@Service
public class AvaliacaoService implements IAvaliacaoService {

	@Autowired
	AvaliacaoRepository repository;

	@Override
	public Avaliacao saveAvaliacao(AvaliacaoDTO avaliacaoDTO) {
		Usuario usuario = new Usuario();
		usuario.setId(avaliacaoDTO.getIdUsuario());
		Produto produto = new Produto();
		produto.setId(avaliacaoDTO.getIdProduto());
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setNota(avaliacaoDTO.getNota());
		avaliacao.setDescricao(avaliacaoDTO.getDescricao());
		avaliacao.setTitulo(avaliacaoDTO.getTitulo());
		avaliacao.setIdProduto(produto);
		avaliacao.setIdUsuario(usuario);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		avaliacao.setData(formatter.format(new Date()));
		return repository.saveAndFlush(avaliacao);
	}

}
