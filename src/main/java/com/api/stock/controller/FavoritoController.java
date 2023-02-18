package com.api.stock.controller;

import com.api.stock.entity.Favorito;
import com.api.stock.interfaces.IFavoritoService;
import com.api.stock.model.FavoritoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Tag(name = "API Favorito")
@RequestMapping("/api/favorito")
public class FavoritoController {

    @Autowired
    IFavoritoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar Favorito")
    public Favorito salvarFavorito(@RequestBody FavoritoDTO favorito) {
        return service.adicionarFavorito(favorito);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Excluir endereço")
    public void deletarFavorito(@PathVariable("id") Integer id) {
        service.removerFavorito(id);
    }
}
