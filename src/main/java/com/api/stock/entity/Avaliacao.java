package com.api.stock.entity;

import com.api.stock.model.ProdutoDTO;
import com.api.stock.model.UsuarioDTO;

public class Avaliacao {
	
	private Integer id;
	private ProdutoDTO idProduto;
	private UsuarioDTO idUsuario;
	private String titulo;
	private String descricao;
	private Integer nota;
	private String data;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getNota() {
		return nota;
	}
	public void setNota(Integer nota) {
		this.nota = nota;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public ProdutoDTO getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(ProdutoDTO idProduto) {
		this.idProduto = idProduto;
	}
	public UsuarioDTO getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(UsuarioDTO idUsuario) {
		this.idUsuario = idUsuario;
	}

}
