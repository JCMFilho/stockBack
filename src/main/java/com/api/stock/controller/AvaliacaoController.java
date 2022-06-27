package com.api.stock.controller;

import java.util.List;

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
import com.api.stock.service.AvaliacaoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API Avaliação")
@RestController
@RequestMapping("/api/avaliacao")
@CrossOrigin
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@Operation(summary = "Buscar avaliação", description = "Retorna todas as avaliações de um produto")
	@GetMapping("/{idProduto}")
	public List<AvaliacaoDTO> buscarAvaliacao(@PathVariable("idProduto") Integer id){
		return avaliacaoService.getAvaliacao();
	}
	
	@Operation(summary = "Cadastrar avaliação")
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Avaliacao postAvalicao(@RequestBody Avaliacao avaliacao) {
		return avaliacao;
	}

}
