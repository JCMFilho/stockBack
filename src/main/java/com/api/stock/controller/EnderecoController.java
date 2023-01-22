package com.api.stock.controller;

import java.util.List;

import com.api.stock.entity.Endereco;
import com.api.stock.interfaces.IEnderecoService;
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

@CrossOrigin
@RestController
@Tag(name = "API Endereço")
@RequestMapping("/api/endereco")
public class EnderecoController {
	
	@Autowired
	private IEnderecoService enderecoService;

	@GetMapping("/{idUsuario}")
	@Operation(summary = "Buscar endereço", description = "Retorna todos os endereços de um usuário")
	public List<Endereco> buscarEnderecosPorUsuario(@PathVariable("idUsuario") String id){
		return enderecoService.getEnderecoByUserId(id);
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

}
