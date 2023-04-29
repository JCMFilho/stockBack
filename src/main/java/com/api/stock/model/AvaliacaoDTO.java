package com.api.stock.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvaliacaoDTO {

	private String titulo;
	private String descricao;
	private Integer nota;
	private String idUsuario;
	private Integer idProduto;

}
