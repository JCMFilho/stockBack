package com.api.stock.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvaliacaoDTO {
	
	private String id;
	private String nome;
	private String titulo;
	private String descricao;
	private Integer nota;
	private String data;

}
