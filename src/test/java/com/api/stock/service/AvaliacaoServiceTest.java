package com.api.stock.service;

import com.api.stock.model.AvaliacaoDTO;
import com.api.stock.repository.AvaliacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AvaliacaoServiceTest {

    @InjectMocks
    AvaliacaoService service;

    @Mock
    AvaliacaoRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveAvaliacao(){
        var avaliacao = new AvaliacaoDTO();
        avaliacao.setIdUsuario("1Y6ULkt7uIRr3s1J0Or3tJw4hMa2");
        avaliacao.setIdProduto(10);
        avaliacao.setDescricao("Teste");
        avaliacao.setNota(10);
        assertDoesNotThrow(()->service.saveAvaliacao(avaliacao));
    }
}
