package com.api.stock.model;

public class ProdutoDTO {
	private Integer id;
	private String nome;
	private Integer estoque;
	private String descricao;
	private Integer totalAcessos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getTotalAcessos() {
		return totalAcessos;
	}
	public void setTotalAcessos(Integer totalAcessos) {
		this.totalAcessos = totalAcessos;
	}
}
