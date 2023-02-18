package com.api.stock.entity;

import com.api.stock.model.EnderecoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@JsonIgnore
	private Usuario idUsuario;
	private String tipo;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;

	public Endereco(EnderecoDTO dto){
		this.bairro = dto.getBairro();
		this.cep = dto.getCep();
		this.id = dto.getId();
		this.cidade = dto.getCidade();
		this.estado = dto.getEstado();
		this.logradouro = dto.getLogradouro();
		this.numero = dto.getNumero();
		this.tipo = dto.getTipo();
		Usuario usuario = new Usuario();
		usuario.setId(dto.getUsuarioId());
		this.idUsuario = usuario;
	}
}
