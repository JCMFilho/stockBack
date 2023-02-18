package com.api.stock.interfaces;

import com.api.stock.entity.Usuario;
import com.api.stock.model.Login;

import java.util.List;

public interface IUsuarioService {

	Usuario getUsuario(String id);

	Usuario getUsuarioPorEmail(String email);

	List<Usuario> getUsuarios();

	Usuario postUsuario(Usuario usuario);

	Usuario putUsuario(Usuario usuario);

	Usuario validarLogin(Login login);

	int recuperarSenha(String email);

	boolean trocarSenha(Login login);

}