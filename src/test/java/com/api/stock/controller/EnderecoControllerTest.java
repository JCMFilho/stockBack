package com.api.stock.controller;

import com.api.stock.interfaces.IEnderecoService;
import com.api.stock.model.EnderecoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

public class EnderecoControllerTest {
    @Mock
    IEnderecoService service;

    @InjectMocks
    EnderecoController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void buscarEnderecosPorUsuarioTest() {
        assertNotNull(controller.buscarEnderecosPorUsuario("21312"));
    }

    @Test
    public void buscarEnderecoPrincipalTest() {
        assertNull(controller.buscarEnderecoPrincipal("21312"));
    }

    @Test
    public void deleteEnderecoTest() {
        assertDoesNotThrow(() -> controller.deleteEndereco(1));
    }

    @Test
    public void postEnderecoTest() {
        assertNull(controller.postEndereco(new EnderecoDTO()));
    }

    @Test
    public void definirEnderecoPrincipal() {
        assertDoesNotThrow(() -> controller.definirEnderecoPrincipal(1));
    }
}
