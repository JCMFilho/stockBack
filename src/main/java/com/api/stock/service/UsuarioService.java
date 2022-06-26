package com.api.stock.service;

import org.springframework.stereotype.Service;
import com.api.stock.interfaces.IUsuarioService;
import com.api.stock.model.UsuarioDTO;

@Service
public class UsuarioService implements IUsuarioService {

	@Override
	public UsuarioDTO getUsuario() {
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setEmail("sarah@gmail.com");
		usuario.setId(1);
		usuario.setNome("Sarah");
		usuario.setCidade("Belo Horizonte");
		usuario.setDataCadastro("10/01/2005");
		return usuario;
	}

}
