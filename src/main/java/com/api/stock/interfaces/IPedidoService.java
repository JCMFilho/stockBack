package com.api.stock.interfaces;

import com.api.stock.entity.Pedido;
import com.api.stock.model.CarrinhoPedidoDTO;
import com.api.stock.model.PedidoUpdateDTO;

import java.util.List;

public interface IPedidoService {

    Pedido salvarPedido(CarrinhoPedidoDTO carrinhoPedido);


    void atualizarStatus(PedidoUpdateDTO pedido);

    List<Pedido> listarPedidosPorUsuario(String idUsuario);
}
