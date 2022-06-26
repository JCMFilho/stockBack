package com.api.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.stock.model.UsuarioDTO;
import com.api.stock.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API Usuario")
@RestController
@RequestMapping("/api/usuario")
@CrossOrigin
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	

	@Operation(summary = "Buscar usuário")
	@GetMapping("/{id}")
	public UsuarioDTO buscarUsuario(@PathVariable("id") Integer id){
		return usuarioService.getUsuario();
	}
	
	
	@Operation(summary = "Cadastrar usuário")
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioDTO postUsuario(@RequestBody UsuarioDTO usuario) {
		return usuario;
	}
	
	@Operation(summary = "Fazer login")
	@GetMapping("/autenticar")
	public void autenticar(@RequestParam("email") String email, @RequestParam("senha") String senha) {	
	}
	
	@Operation(summary = "Atualizar usuário")
	@PutMapping("")
	public UsuarioDTO putUsuario(@RequestBody UsuarioDTO usuario) {
		return usuario;
	}
	
}