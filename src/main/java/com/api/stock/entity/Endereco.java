package com.api.stock.entity;

import com.api.stock.model.UsuarioDTO;

public class Endereco {
	
	private Integer id;
	private UsuarioDTO idUsuario;
	private String tipo;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public UsuarioDTO getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(UsuarioDTO idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

}
