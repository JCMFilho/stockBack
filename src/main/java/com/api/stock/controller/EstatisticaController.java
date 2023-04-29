package com.api.stock.controller;

import com.api.stock.interfaces.IEstatisticaService;
import com.api.stock.model.EstatisticaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Tag(name = "API Estatística")
@RequestMapping("/api/estatistica")
public class EstatisticaController {

    @Autowired
    IEstatisticaService service;

    @GetMapping
    @Operation(summary = "Buscar estatísticas", description = "Busca as estatísticas do sistema para geração de relatório")
    public EstatisticaDTO buscarEstatisticas(){
        return service.buscarEstatisticas();
    }
}
