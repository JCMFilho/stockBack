package com.api.stock.controller;

import com.api.stock.entity.Pedido;
import com.api.stock.interfaces.IPedidoService;
import com.api.stock.model.CarrinhoPedidoDTO;
import com.api.stock.model.PedidoUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Tag(name = "API Pedido")
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    IPedidoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Efetuar pedido")
    public Pedido salvarPedido(@RequestBody  CarrinhoPedidoDTO carrinhoPedido) {
        return service.salvarPedido(carrinhoPedido);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar status pedido")
    public void atualizarStatus(@RequestBody PedidoUpdateDTO pedidoUpdate) {
        service.atualizarStatus(pedidoUpdate);
    }

    @GetMapping("/{idUsuario}")
    @Operation(summary = "Listar Pedidos", description = "Retorna todos os pedidos do usuário logado no sistema")
    public List<Pedido> listarPedidosPorUsuario(@PathVariable("idUsuario") String idUsuario){
        return service.listarPedidosPorUsuario(idUsuario);
    }
}
