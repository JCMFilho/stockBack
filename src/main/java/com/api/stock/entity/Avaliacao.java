package com.api.stock.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	@JsonIgnore
	private Produto idProduto;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario idUsuario;

	@Column(name="TITULO")
	private String titulo;

	@Column(name="DESCRICAO")
	private String descricao;
	@Column(name="NOTA")
	private Integer nota;
	@Column(name="DATA")
	private String data;

}
