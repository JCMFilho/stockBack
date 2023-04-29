package com.api.stock.entity;

import com.api.stock.model.FavoritoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="FAVORITO")
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    @JsonIgnore
    private Produto idProduto;

    public Favorito(FavoritoDTO favorito){
            Usuario usu = new Usuario();
            usu.setId(favorito.getIdUsuario());
            this.idUsuario = usu;
            Produto produto = new Produto();
            produto.setId(favorito.getIdProduto());
            this.idProduto = produto;
    }
}
