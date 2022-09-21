package com.rentacar.rentacar_api.form;

import java.time.LocalDate;
import java.util.Optional;

import com.rentacar.rentacar_api.model.Usuario;
import com.rentacar.rentacar_api.repository.UsuarioRepository;

public class UsuarioFormAtualizacao {

	private String login;
	private String senha;
	private String nome;
	
	
	public Usuario atualizar(Long id, UsuarioRepository usuarioRepo) {
		Optional<Usuario> u = usuarioRepo.findById(id);
		if(u.isPresent()) {
			Usuario usuario= u.get();
			usuario.setLogin(this.login);
			usuario.setSenha(this.senha);
			usuario.setNome(this.nome);
			usuario.setDataModificacao(LocalDate.now());
			return usuario;
		}
		
		return null;
	}

}
