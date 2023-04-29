package com.api.stock.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarrinhoPedidoDTO {

    private Integer idCarrinho;
    private String idUsuario;
    private String frete;
    private String total;
}
