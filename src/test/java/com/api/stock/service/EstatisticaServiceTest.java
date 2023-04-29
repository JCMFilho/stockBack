package com.api.stock.service;

import com.api.stock.repository.PedidoItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EstatisticaServiceTest {

    @InjectMocks
    EstatisticaService service;

    @Mock
    PedidoItemRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBuscarEstatisticas(){
        assertNotNull(service.buscarEstatisticas());
    }
}
