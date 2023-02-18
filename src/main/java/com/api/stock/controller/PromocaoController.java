package com.api.stock.controller;

import com.api.stock.entity.Promocao;
import com.api.stock.interfaces.IPromocaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Tag(name = "API Promoção")
@RequestMapping("/api/promocao")
public class PromocaoController {

    @Autowired
    IPromocaoService promocaoService;

    @GetMapping("/{tipo}")
    @Operation(summary = "Buscar promoção por tipo")
    public List<Promocao> getPromocaoByTipo(@PathVariable("tipo") String tipo){
        return promocaoService.getPromocaoByTipo(tipo);
    }
}
