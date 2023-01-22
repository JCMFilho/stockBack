package com.api.stock.controller;

import com.api.stock.entity.Departamento;
import com.api.stock.interfaces.IDepartarmentoService;
import com.api.stock.model.AvaliacaoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Tag(name = "API Departamento")
@RequestMapping("/api/departamento")
public class DepartamentoController {

    @Autowired
    IDepartarmentoService service;

    @GetMapping
    @Operation(summary = "Listar Departamentos", description = "Retorna todos os departamentos cadastrados")
    public List<Departamento> listarDepartamentos(){
        return service.listarDepartamentos();
    }

    @PostMapping
    @Operation(summary = "Cadastrar Departamentos", description = "Cadastra um novo departamento")
    public Departamento salvarDepartamento(@RequestBody Departamento departamento){
        return service.salvarDepartamento(departamento);
    }
}
