package com.api.stock.controller;

import com.api.stock.entity.Avaliacao;
import com.api.stock.interfaces.IAvaliacaoService;
import com.api.stock.model.AvaliacaoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Tag(name = "API Avaliação")
@RequestMapping("/api/avaliacao")

public class AvaliacaoController {
	
	@Autowired
	IAvaliacaoService avaliacaoService;

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Cadastrar avaliação")
	public Avaliacao postAvalicao(@RequestBody AvaliacaoDTO avaliacao) {
		return avaliacaoService.saveAvaliacao(avaliacao);
	}

}
