package com.rentacar.rentacar_api.dto;

import java.time.LocalDate;

import com.rentacar.rentacar_api.model.Usuario;

public class UsuarioDto {
	

	private String login;
	private String nome;	
	private LocalDate dataCriacao;
	private LocalDate dataModificacao;

	public UsuarioDto(Usuario u) {
		this.login = u.getLogin();
		this.nome = u.getNome();
		this.dataCriacao = u.getDataCriacao();
		this.dataModificacao = u.getDataModificacao();
	}

	public UsuarioDto(String login, String nome, LocalDate dataCriacao, LocalDate dataModificacao) {
		this.login = login;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.dataModificacao = dataModificacao;
	}


	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public LocalDate getDataModificacao() {
		return dataModificacao;
	}
	public void setDataModificacao(LocalDate dataModificacao) {
		this.dataModificacao = dataModificacao;
	}


}


