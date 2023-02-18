package com.api.stock.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @Column(name = "ID")
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String celular;
    private String cpf;
    private String rg;
    private String role;
    private String avatar;
    private String senha;
    private String dataCadastro;

}
