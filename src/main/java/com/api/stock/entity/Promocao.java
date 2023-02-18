package com.api.stock.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Promocao {

    @Id
    private Integer id;
    private String imagem;
    @Column(name = "departamento_id")
    private Integer departamentoId;
    private String tipo;

}