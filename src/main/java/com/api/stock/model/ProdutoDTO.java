package com.api.stock.model;

import com.api.stock.entity.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProdutoDTO {

	private Integer id;
	private String nome;
	private Integer estoque;
	private String descricao;
	private Integer totalAcessos;
	private String imagem;
	private Integer preco;
	private Integer departamentoId;
	private String departamento;
	private Boolean isFavorito;
	private Integer favoritoId;

	public ProdutoDTO(Produto produto, Integer favoritoId){
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.estoque = produto.getEstoque();
		this.totalAcessos = produto.getTotalAcessos();
		this.imagem = produto.getImagem();
		this.preco = produto.getPreco();
		this.departamentoId = produto.getDepartamento().getId();
		this.departamento = produto.getDepartamento().getNome();
		this.favoritoId = favoritoId;
		this.isFavorito = favoritoId != null;
	}



}
