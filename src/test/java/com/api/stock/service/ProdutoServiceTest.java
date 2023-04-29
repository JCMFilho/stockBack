package com.api.stock.service;

import com.api.stock.entity.Departamento;
import com.api.stock.entity.Produto;
import com.api.stock.model.ProdutoDTO;
import com.api.stock.repository.DepartamentoRepository;
import com.api.stock.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ProdutoServiceTest {

    @InjectMocks
    ProdutoService service;

    @Mock
    ProdutoRepository repository;

    @Mock
    DepartamentoRepository repositoryDepartamento;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getProdutoTest() {
        var produto = new Produto();
        produto.setTotalAcessos(1);
        when(repository.buscarPorId(any())).thenReturn(produto);
        assertEquals(2, service.getProduto(10).getTotalAcessos());
    }

    @Test
    void salvarProdutoTest() {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        when(repository.saveAndFlush(any())).thenReturn(new Produto());
        when(repositoryDepartamento.saveAndFlush(any())).thenReturn(new Departamento());
        assertDoesNotThrow(() -> service.salvarProduto(produtoDTO));
    }

    @Test
    void deleteProdutoTest() {
        assertDoesNotThrow(() -> service.deleteProduto(2));
    }

    @Test
    void listarProdutosTest() {
        assertDoesNotThrow(() -> service.listarProdutos("1Y6ULkt7uIRr3s1J0Or3tJw4hMa2"));
    }

    @Test
    void listarProdutosPorDepartamentoTest() {
        assertDoesNotThrow(() -> service.listarProdutosPorDepartamento(2, "1Y6ULkt7uIRr3s1J0Or3tJw4hMa2"));
    }

    @Test
    void buscarProdutosPorNomeTest() {
        assertDoesNotThrow(() -> service.buscarProdutosPorNome("Telha", "1Y6ULkt7uIRr3s1J0Or3tJw4hMa2"));
    }

    @Test
    void findFavoritosByUsuarioTest() {
        assertDoesNotThrow(() -> service.findFavoritosByUsuario("1Y6ULkt7uIRr3s1J0Or3tJw4hMa2"));
    }

}
