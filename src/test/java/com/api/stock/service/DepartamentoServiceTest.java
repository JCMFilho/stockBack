package com.api.stock.service;

import com.api.stock.entity.Departamento;
import com.api.stock.repository.DepartamentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DepartamentoServiceTest {
    @InjectMocks
    DepartamentoService service;

    @Mock
    DepartamentoRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarDepartamentos(){
        when(repository.findAll()).thenReturn(new ArrayList<>());
        assertNotNull(service.listarDepartamentos());
    }

    @Test
    void testSalvarDepartamento(){
        Departamento d = new Departamento();
        when(repository.saveAndFlush(any())).thenReturn(d);
        assertEquals(d, service.salvarDepartamento(d));
    }
}
