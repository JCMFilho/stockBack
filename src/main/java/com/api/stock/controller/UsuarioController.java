package com.api.stock.controller;

import com.api.stock.entity.Usuario;
import com.api.stock.model.Login;
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

import com.api.stock.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@CrossOrigin
@RestController
@Tag(name = "API Usuário")
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar usuário")
	public Usuario getUsuario(@PathVariable("id") String id){
		return usuarioService.getUsuario(id);
	}

	@GetMapping("")
	@Operation(summary = "Buscar usuários")
	public List<Usuario> getUsuarios(){
		return usuarioService.getUsuarios();
	}


	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Cadastrar usuário")
	public String postUsuario(@RequestBody Usuario usuario) {
		return usuarioService.postUsuario(usuario);
	}


	@PutMapping("")
	@Operation(summary = "Atualizar usuário")
	public Usuario putUsuario(@RequestBody Usuario usuario) {
		return usuario;
	}

	@PostMapping("/login")
	@Operation(summary = "Realizar Login")
	public Usuario login(@RequestBody Login login){
		return usuarioService.validarLogin(login);
	}
	
}