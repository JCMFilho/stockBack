package com.api.stock.service;

import com.api.stock.entity.Promocao;
import com.api.stock.repository.PromocaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PromocaoServiceTest {

    @InjectMocks
    PromocaoService service;

    @Mock
    PromocaoRepository promocaoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getPromocaoByTipoTest() {
        var retorno = new ArrayList<Promocao>();
        when(promocaoRepository.findByTipo(any())).thenReturn(retorno);
        assertEquals(retorno, service.getPromocaoByTipo("D"));
    }
}
