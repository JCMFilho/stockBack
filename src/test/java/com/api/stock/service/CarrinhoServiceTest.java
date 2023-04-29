package com.api.stock.service;

import com.api.stock.entity.Carrinho;
import com.api.stock.entity.Produto;
import com.api.stock.entity.ProdutoCarrinho;
import com.api.stock.entity.Usuario;
import com.api.stock.repository.CarrinhoRepository;
import com.api.stock.repository.ProdutoCarrinhoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CarrinhoServiceTest {

    @InjectMocks
    private CarrinhoService carrinhoService;

    @Mock
    private CarrinhoRepository carrinhoRepository;

    @Mock
    private ProdutoCarrinhoRepository produtoCarrinhoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCarrinhoPorUsuarioId() {
        Carrinho carrinho = new Carrinho();
        carrinho.setId(1);
        Usuario usuario = new Usuario();
        usuario.setId("123");
        carrinho.setIdUsuario(usuario);
        when(carrinhoRepository.getByUserId(any())).thenReturn(carrinho);

        Carrinho resultado = carrinhoService.getCarrinhoPorUsuarioId("123");

        assertThat(resultado).isEqualTo(carrinho);
    }

    @Test
    public void testInserirProdutoCarrinho() {
        // Criando um produto
        Produto produto = new Produto();
        produto.setId(1);
        produto.setNome("Produto 1");

        // Criando um produto carrinho
        ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho();
        produtoCarrinho.setId(1);
        produtoCarrinho.setProduto(produto);
        produtoCarrinho.setQuantidade(1);
        produtoCarrinho.setUsuarioId("123");

        carrinhoService.inserirProdutoCarrinho(produtoCarrinho);
    }

    @Test
    public void testAtualizarProdutoCarrinho() {
        // Criando um produto
        Produto produto = new Produto();
        produto.setId(1);
        produto.setNome("Produto 1");

        // Criando um produto carrinho
        ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho();
        produtoCarrinho.setId(1);
        produtoCarrinho.setProduto(produto);
        produtoCarrinho.setQuantidade(1);
        produtoCarrinho.setUsuarioId("123");
        when(produtoCarrinhoRepository.findById(any())).thenReturn(Optional.of(produtoCarrinho));
        assertDoesNotThrow(() -> carrinhoService.atualizarProdutoCarrinho(produtoCarrinho));
    }

    @Test
    public void testDeleteItemCarrinho() {
        // Criando um produto
        Produto produto = new Produto();
        produto.setId(1);
        produto.setNome("Produto 1");

        // Criando um produto carrinho
        ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho();
        produtoCarrinho.setId(1);
        produtoCarrinho.setProduto(produto);
        produtoCarrinho.setQuantidade(1);
        produtoCarrinho.setUsuarioId("123");
        Carrinho c = new Carrinho();
        c.setTotal(20);
        produtoCarrinho.setCarrinho(c);
        when(produtoCarrinhoRepository.findById(any())).thenReturn(Optional.of(produtoCarrinho));

        assertDoesNotThrow(() -> carrinhoService.deleteItemCarrinho(1  ));
    }
}