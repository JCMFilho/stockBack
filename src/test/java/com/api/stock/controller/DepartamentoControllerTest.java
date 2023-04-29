package com.api.stock.controller;

import com.api.stock.entity.Departamento;
import com.api.stock.interfaces.IDepartarmentoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DepartamentoControllerTest {

    @Mock
    IDepartarmentoService service;

    @InjectMocks
    DepartamentoController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void listarDepartamentosTest() {
        assertNotNull(controller.listarDepartamentos());
    }

    @Test
    public void salvarDepartamentoTest() {
        assertNull(controller.salvarDepartamento(new Departamento()));
    }
}
