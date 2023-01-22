package com.api.stock.service;

import com.api.stock.entity.Produto;
import com.api.stock.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.stock.interfaces.IProdutoService;
import com.api.stock.model.ProdutoDTO;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdutoService implements IProdutoService {

	@Autowired
	ProdutoRepository repository;

	@Override
	public Produto getProduto(Integer id) {
		Produto produto = repository.buscarPorId(id);
		produto.setTotalAcessos(produto.getTotalAcessos() + 1);
		repository.saveAndFlush(produto);
		return produto;
	}

	@Override
	public Produto salvarProduto(ProdutoDTO produto) {
		return repository.saveAndFlush(new Produto(produto));
	}

	@Override
	@Transactional
	public void deleteProduto(Integer id){
		repository.deleteById(id);
	}

	@Override
	public List<ProdutoDTO> listarProdutos(String idUsuario) {
		return repository.listarProdutos(idUsuario);
	}

	@Override
	public List<ProdutoDTO> listarProdutosPorDepartamento(Integer departamentoId,String idUsuario) {
		return repository.listarPorDepartamento(departamentoId,idUsuario);
	}


}
