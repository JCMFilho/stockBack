package com.api.stock.controller;

import com.api.stock.entity.ProdutoCarrinho;
import com.api.stock.interfaces.ICarrinhoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CarrinhoControllerTest {

    @Mock
    ICarrinhoService carrinhoService;

    @InjectMocks
    CarrinhoController controller;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void buscarCarrinhoPorUsuarioTest() {
        assertNull(controller.buscarCarrinhoPorUsuario("12"));
    }

    @Test
    public void inserirProdutoCarrinhoTest() {
        assertNull(controller.inserirProdutoCarrinho(new ProdutoCarrinho()));
    }

    @Test
    public void atualizarProdutoCarrinhoTest() {
        assertDoesNotThrow(() -> controller.atualizarProdutoCarrinho(new ProdutoCarrinho()));
    }

    @Test
    public void deleteItemCarrinhoTest() {
        assertDoesNotThrow(() -> controller.deleteItemCarrinho(12));
    }

}
