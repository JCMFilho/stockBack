package com.api.stock.repository;

import com.api.stock.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByIdUsuarioId(String idUsuario);
}
