package com.rentacar.rentacar_api.form.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioForm {
	
	private String login;
	private String senha;
	private String nome;

}
