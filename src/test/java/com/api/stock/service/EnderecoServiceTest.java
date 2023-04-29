package com.api.stock.service;

import com.api.stock.entity.Endereco;
import com.api.stock.entity.Usuario;
import com.api.stock.model.EnderecoDTO;
import com.api.stock.repository.EnderecoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class EnderecoServiceTest {
    @InjectMocks
    EnderecoService service;
    @Mock
    EnderecoRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testEnderecoByUserId(){
        when(repository.findAllByidUsuarioId(any())).thenReturn(new ArrayList<>());
        assertNotNull(service.getEnderecoByUserId("1Y6ULkt7uIRr3s1J0Or3tJw4hMa2"));
    }

    @Test
    void testSaveEndereco(){
        Endereco end = new Endereco();
        end.setId(20);
        Usuario usu = new Usuario();
        usu.setId("1Y6ULkt7uIRr3s1J0Or3tJw4hMa2");
        end.setIdUsuario(usu);
        when(repository.saveAndFlush(any())).thenReturn(end);
        when(repository.findById(any())).thenReturn(Optional.of(end));
        when(repository.findAllByidUsuarioIdAndEnderecoPrincipal("1Y6ULkt7uIRr3s1J0Or3tJw4hMa2", true)).thenReturn(List.of(end));
        assertNotNull(service.saveEndereco(new EnderecoDTO()));
    }


    @Test
    void testBuscarEnderecoPrincipal(){
        Endereco end = new Endereco();
        end.setId(20);
        when(repository.findAllByidUsuarioIdAndEnderecoPrincipal("1Y6ULkt7uIRr3s1J0Or3tJw4hMa2", true)).thenReturn(List.of(end));
        assertEquals(end,service.buscarEnderecoPrincipal("1Y6ULkt7uIRr3s1J0Or3tJw4hMa2"));
    }

    @Test
    void testDeleteEndereco(){
        assertDoesNotThrow(() -> service.deleteEndereco(20));
    }
}
