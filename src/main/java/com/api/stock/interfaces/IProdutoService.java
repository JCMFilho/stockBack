package com.api.stock.interfaces;

import com.api.stock.entity.Produto;
import com.api.stock.model.ProdutoDTO;

import java.util.List;

public interface IProdutoService {
	
	Produto getProduto(Integer id);

	Produto salvarProduto(ProdutoDTO produto);

	List<ProdutoDTO> listarProdutos(String idUsuario);

	List<ProdutoDTO> listarProdutosPorDepartamento(Integer departamentoId,String idUsuario);

	void deleteProduto(Integer id);
	
}
