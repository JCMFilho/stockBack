package com.api.stock.controller;

import java.util.List;

import com.api.stock.interfaces.IAvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.stock.entity.Avaliacao;
import com.api.stock.model.AvaliacaoDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@Tag(name = "API Avaliação")
@RequestMapping("/api/avaliacao")

public class AvaliacaoController {
	
	@Autowired
	IAvaliacaoService avaliacaoService;

	@GetMapping("/{idProduto}")
	@Operation(summary = "Buscar avaliação", description = "Retorna todas as avaliações de um produto")
	public List<AvaliacaoDTO> buscarAvaliacao(@PathVariable("idProduto") Integer id){
		return avaliacaoService.getAvaliacao();
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Cadastrar avaliação")
	public Avaliacao postAvalicao(@RequestBody Avaliacao avaliacao) {
		return avaliacao;
	}

}
