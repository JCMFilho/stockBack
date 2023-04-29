package com.api.stock.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "PEDIDO")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario idUsuario;

    @Column(name = "TOTAL")
    private String total;

    @Column(name = "FRETE")
    private String frete;

    @Column(name = "DATA")
    private String data;

    @Column(name = "STATUS")
    private String status;
    @OneToMany(mappedBy = "pedido")
    private Set<PedidoItem> items;



}
