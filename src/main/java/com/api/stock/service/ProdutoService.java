package com.api.stock.service;

import org.springframework.stereotype.Service;

import com.api.stock.interfaces.IProdutoService;
import com.api.stock.model.ProdutoDTO;

@Service
public class ProdutoService implements IProdutoService {
	
	@Override
	public ProdutoDTO getProduto() {
		ProdutoDTO produto = new ProdutoDTO();
		produto.setId(1);
		produto.setNome("Cimento");
		produto.setEstoque(50);
		produto.setDescricao("Utilizado para pequenos reparos e não deve ser utilizado em concretos");
		produto.setTotalAcessos(15);
		return produto;
	}
	
}
