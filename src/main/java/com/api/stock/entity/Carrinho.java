package com.api.stock.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "CARRINHO")
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario idUsuario;

    @Column(name = "TOTAL")
    private Integer total;
    @OneToMany(mappedBy = "carrinho")
    private Set<ProdutoCarrinho> produtos;
}
