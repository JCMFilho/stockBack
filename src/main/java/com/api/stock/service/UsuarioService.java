package com.api.stock.service;

import com.api.stock.entity.Usuario;
import com.api.stock.model.Login;
import com.api.stock.repository.UsuarioRepository;
import com.api.stock.util.DateUtil;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.api.stock.interfaces.IUsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	RecuperarSenhaService recuperarSenhaService;

	@Override
	public Usuario getUsuario(String id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElse(new Usuario());
	}

	@Override
	public Usuario getUsuarioPorEmail(String email) {
		Optional<Usuario> usuario = usuarioRepository.findUsuarioByEmail(email);
		return usuario.orElse(new Usuario());
	}

	@Override
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario postUsuario(Usuario usuario) {
		usuario.setDataCadastro(StringUtils.isEmpty(usuario.getDataCadastro()) ? DateUtil.getCurrentDate() : usuario.getDataCadastro());
		usuario.setSenha(StringUtils.isEmpty(usuario.getSenha()) ? "" : bCryptPasswordEncoder.encode(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario putUsuario(Usuario usuario) {
		usuario.setDataCadastro(StringUtils.isEmpty(usuario.getDataCadastro()) ? DateUtil.getCurrentDate() : usuario.getDataCadastro());
		usuario.setSenha(StringUtils.isEmpty(usuario.getSenha()) ? getUsuario(usuario.getId()).getSenha() : bCryptPasswordEncoder.encode(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario validarLogin(Login login) {
		Optional<Usuario> usu = usuarioRepository.findUsuarioByEmail(login.getLogin());
		if (usu.isEmpty()) {
			return new Usuario();
		}
		if (bCryptPasswordEncoder.matches(login.getSenha(), usu.get().getSenha()))
			return usu.get();
		else
			return new Usuario();
	}

	@Override
	public int recuperarSenha(String email) {
		Random codeGenerator = new Random();
		int code = codeGenerator.nextInt(1000000);
		String messageBody = "O seu código para recuperar a senha é: " + code;
		recuperarSenhaService.sendPasswordRecoveryEmail(email,"Recuperação de senha", messageBody);
		return code;
	}

	@Override
	public boolean trocarSenha(Login login) {
		Usuario usuario = getUsuarioPorEmail(login.getLogin());
		usuario.setSenha(bCryptPasswordEncoder.encode(login.getSenha()));
		usuarioRepository.saveAndFlush(usuario);
		return true;
	}

}
