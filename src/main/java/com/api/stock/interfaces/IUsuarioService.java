package com.api.stock.interfaces;

import com.api.stock.entity.Usuario;
import com.api.stock.model.Login;

import java.util.List;

public interface IUsuarioService {

	Usuario getUsuario(String id);

	List<Usuario> getUsuarios();

	String postUsuario(Usuario usuario);

	Usuario validarLogin(Login login);
	
}