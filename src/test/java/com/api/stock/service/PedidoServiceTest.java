package com.api.stock.service;

import com.api.stock.entity.Carrinho;
import com.api.stock.entity.Pedido;
import com.api.stock.entity.ProdutoCarrinho;
import com.api.stock.model.CarrinhoPedidoDTO;
import com.api.stock.model.PedidoUpdateDTO;
import com.api.stock.repository.CarrinhoRepository;
import com.api.stock.repository.PedidoItemRepository;
import com.api.stock.repository.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PedidoServiceTest {

    @InjectMocks
    PedidoService service;

    @Mock
    PedidoRepository repository;

    @Mock
    PedidoItemRepository pedidoItemRepository;

    @Mock
    CarrinhoRepository carrinhoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void adicionarFavoritoTest(){
        CarrinhoPedidoDTO carrinhoPedidoDTO = new CarrinhoPedidoDTO();
        carrinhoPedidoDTO.setIdUsuario("1Y6ULkt7uIRr3s1J0Or3tJw4hMa2");
        carrinhoPedidoDTO.setTotal("200");
        carrinhoPedidoDTO.setIdCarrinho(10);
        carrinhoPedidoDTO.setFrete("20");
        Carrinho c = new Carrinho();
        c.setId(1);
        c.setProdutos(Set.of(new ProdutoCarrinho(),new ProdutoCarrinho()));
        when(carrinhoRepository.findById(any())).thenReturn(Optional.of(c));
        when(repository.save(any())).thenReturn(new Pedido());
        assertDoesNotThrow(() -> service.salvarPedido(carrinhoPedidoDTO));
    }

    @Test
    void listarPedidosPorUsuarioTest(){
        when(repository.findByIdUsuarioId(any())).thenReturn(new ArrayList<>());
        assertNotNull(service.listarPedidosPorUsuario("1Y6ULkt7uIRr3s1J0Or3tJw4hMa2"));
    }

    @Test
    void atualizarStatusTest(){
        assertDoesNotThrow(()-> service.atualizarStatus(new PedidoUpdateDTO()));
    }
}
