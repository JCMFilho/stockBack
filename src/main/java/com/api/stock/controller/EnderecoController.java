package com.api.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.stock.model.EnderecoDTO;
import com.api.stock.service.EnderecoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API Endereço")
@RestController
@RequestMapping("/api/endereco")
@CrossOrigin
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Operation(summary = "Buscar endereço", description = "Retorna todos os endereços de um usuário")
	@GetMapping("/{idUsuario}")
	public List<EnderecoDTO> buscarAvaliacao(@PathVariable("idUsuario") Integer id){
		return enderecoService.getEndereco();
	}
	
	@Operation(summary = "Cadastrar endereço")
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public EnderecoDTO postEndereco(@RequestBody EnderecoDTO endereco) {
		return endereco;
	}
	
	@Operation(summary = "Atualizar endereço")
	@PutMapping("")
	public EnderecoDTO putEndereco(@RequestBody EnderecoDTO endereco) {
		return endereco;
	}
	
	@Operation(summary = "Excluir endereço")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEndereco(@PathVariable("id") Integer id) {
		
	}

}
