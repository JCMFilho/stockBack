package com.api.stock.controller;

import com.api.stock.interfaces.IAvaliacaoService;
import com.api.stock.model.AvaliacaoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNull;

public class AvaliacaoControllerTest {

    @Mock
    IAvaliacaoService service;

    @InjectMocks
    AvaliacaoController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void postAvalicaoTest() {
        assertNull(controller.postAvalicao(new AvaliacaoDTO()));
    }
}
