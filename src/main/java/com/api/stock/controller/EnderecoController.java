package com.api.stock.controller;

import java.util.List;

import com.api.stock.entity.Endereco;
import com.api.stock.interfaces.IEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.api.stock.model.EnderecoDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@Tag(name = "API Endereço")
@RequestMapping("/api/endereco")
public class EnderecoController {
	
	@Autowired
	IEnderecoService enderecoService;

	@GetMapping("/{idUsuario}")
	@Operation(summary = "Buscar endereço", description = "Retorna todos os endereços de um usuário")
	public List<Endereco> buscarEnderecosPorUsuario(@PathVariable("idUsuario") String id){
		return enderecoService.getEnderecoByUserId(id);
	}

	@GetMapping("/endereco-principal/{idUsuario}")
	@Operation(summary = "Buscar endereço principal do usuário", description = "Retorna o endereço principal do usuário")
	public Endereco buscarEnderecoPrincipal(@PathVariable("idUsuario") String id){
		return enderecoService.buscarEnderecoPrincipal(id);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Cadastrar endereço")
	public Endereco postEndereco(@RequestBody EnderecoDTO endereco) {
		return enderecoService.saveEndereco(endereco);
	}


	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Operation(summary = "Excluir endereço")
	public void deleteEndereco(@PathVariable("id") Integer id) {
		enderecoService.deleteEndereco(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Operation(summary = "Definir endereço como principal")
	public void definirEnderecoPrincipal(@PathVariable("id") Integer id){
		enderecoService.definirEnderecoPrincipal(id);
	}
}
