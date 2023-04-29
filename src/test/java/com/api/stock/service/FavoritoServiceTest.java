package com.api.stock.service;

import com.api.stock.entity.Favorito;
import com.api.stock.model.FavoritoDTO;
import com.api.stock.repository.FavoritoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class FavoritoServiceTest {
    @InjectMocks
    FavoritoService service;
    @Mock
    FavoritoRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void adicionarFavoritoTest(){
        when(repository.saveAndFlush(any())).thenReturn(new Favorito());
        assertNotNull(service.adicionarFavorito(new FavoritoDTO()));
    }

    @Test
    void removerFavoritoTest(){
        assertDoesNotThrow(() -> service.removerFavorito(10));
    }
}
