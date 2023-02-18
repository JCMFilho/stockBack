package com.api.stock.controller;

import com.api.stock.entity.Usuario;
import com.api.stock.interfaces.IUsuarioService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@CrossOrigin
@RestController
@Tag(name = "API Usuário")
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	IUsuarioService usuarioService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar usuário")
	public Usuario getUsuario(@PathVariable("id") String id){
		return usuarioService.getUsuario(id);
	}

	@GetMapping("/email/{email}")
	@Operation(summary = "Buscar usuário pelo e-mail")
	public Usuario getUsuarioByEmail(@PathVariable("email") String email){
		return usuarioService.getUsuarioPorEmail(email);
	}

	@GetMapping("")
	@Operation(summary = "Buscar usuários")
	public List<Usuario> getUsuarios(){
		return usuarioService.getUsuarios();
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Cadastrar usuário")
	public Usuario postUsuario(@RequestBody Usuario usuario) {
		return usuarioService.postUsuario(usuario);
	}

	@PutMapping("")
	@Operation(summary = "Atualizar usuário")
	public Usuario putUsuario(@RequestBody Usuario usuario) {
		return usuarioService.putUsuario(usuario);
	}

	@PostMapping("/login")
	@Operation(summary = "Realizar Login")
	public Usuario login(@RequestBody Login login){
		return usuarioService.validarLogin(login);
	}

	@Operation(summary = "Recuperar senha", description = "Recuperar a senha do usuário do sistema")
	@PostMapping("/recuperar")
	public int recuperarSenha(@RequestBody String email) {
		return usuarioService.recuperarSenha(email);
	}

	@Operation(summary = "Trocar senha", description = "Trocar a senha do usuário do sistema")
	@PostMapping("/trocar")
	public boolean trocarSenha(@RequestBody Login login) {
		return usuarioService.trocarSenha(login);
	}
}