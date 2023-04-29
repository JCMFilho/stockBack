package com.api.stock.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
