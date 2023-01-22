package com.api.stock.service;

import com.api.stock.entity.Usuario;
import com.api.stock.model.Login;
import com.api.stock.repository.UsuarioRepository;
import com.api.stock.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.api.stock.interfaces.IUsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public Usuario getUsuario(String id){
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElse(new Usuario());
	}

	@Override
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public String postUsuario(Usuario usuario) {
		usuario.setDataCadastro(StringUtils.isEmpty(usuario.getDataCadastro()) ? DateUtil.getCurrentDate() : usuario.getDataCadastro());
		usuario.setSenha(StringUtils.isEmpty(usuario.getSenha())? "" : bCryptPasswordEncoder.encode(usuario.getSenha()));
		return usuarioRepository.save(usuario).getId();
	}

	@Override
	public Usuario validarLogin(Login login) {
		Usuario usu = usuarioRepository.findUsuarioByEmail(login.getLogin());
		if(usu == null){
			return new Usuario();
		}
		if(bCryptPasswordEncoder.matches(login.getSenha(), usu.getSenha()))
			return usu;
		else
			return new Usuario();
	}

}
