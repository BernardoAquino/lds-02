package com.rentacar.rentacar_api.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rentacar.rentacar_api.form.usuario.UsuarioForm;
import com.rentacar.rentacar_api.model.Usuario;
import com.rentacar.rentacar_api.repository.UsuarioRepository;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("/autenticar")
	@ResponseBody
	public ResponseEntity autenticarUsuario(@RequestBody @Valid UsuarioForm form) {
		Optional<Usuario> usuarioResult = this.usuarioRepository.findByLoginAndSenha(form.getLogin(), form.getSenha());

		if(usuarioResult.isPresent()) {
			Usuario usuario = usuarioResult.get();
			String hash = DigestUtils.sha256Hex(usuario.getSenha() + usuario.getLogin());

			usuario.setHash(hash);

			this.usuarioRepository.save(usuario);

			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.UNAUTHORIZED);
	}
}
