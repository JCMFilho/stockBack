package com.api.stock.service;

import com.api.stock.entity.Carrinho;
import com.api.stock.entity.Pedido;
import com.api.stock.entity.PedidoItem;
import com.api.stock.entity.Usuario;
import com.api.stock.interfaces.IPedidoService;
import com.api.stock.model.CarrinhoPedidoDTO;
import com.api.stock.model.PedidoUpdateDTO;
import com.api.stock.repository.CarrinhoRepository;
import com.api.stock.repository.PedidoItemRepository;
import com.api.stock.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private PedidoItemRepository pedidoItemRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;


    @Override
    public Pedido salvarPedido(CarrinhoPedidoDTO carrinhoPedido) {
        Carrinho carrinho = carrinhoRepository.findById(carrinhoPedido.getIdCarrinho()).orElse(new Carrinho());
        Usuario usuario = Usuario.builder().id(carrinhoPedido.getIdUsuario()).build();
        Pedido pedido = new Pedido();
        pedido.setFrete(carrinhoPedido.getFrete());
        pedido.setTotal(carrinhoPedido.getTotal());
        pedido.setIdUsuario(usuario);
        pedido.setStatus("Em Andamento");
        pedido.setData(getCurrentDate());
        pedido = repository.save(pedido);
        Pedido finalPedido = pedido;
        Set<PedidoItem> items = carrinho.getProdutos().stream().map(produto -> {
            PedidoItem item = new PedidoItem();
            item.setQuantidade(produto.getQuantidade());
            item.setPedido(finalPedido);
            item.setProduto(produto.getProduto());
            return item;
        }).collect(Collectors.toSet());
        pedidoItemRepository.saveAllAndFlush(items);
        pedido.setItems(items);
        carrinhoRepository.deleteById(carrinho.getId());
        return pedido;
    }

    @Override
    public void atualizarStatus(PedidoUpdateDTO pedidoUpdate) {
        Pedido pedido = repository.findById(pedidoUpdate.getIdPedido()).orElse(new Pedido());
        pedido.setStatus(pedidoUpdate.getStatus());
        pedido.setData(getCurrentDate());
        repository.saveAndFlush(pedido);
    }

    @Override
    public List<Pedido> listarPedidosPorUsuario(String idUsuario) {
        return repository.findByIdUsuarioId(idUsuario);
    }

    private String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
        return formatter.format(new Date());
    }
}
