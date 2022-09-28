package com.rentacar.rentacar_api.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import com.rentacar.rentacar_api.form.agente.AgenteForm;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agente extends Usuario{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Enumerated
	private TipoAgente tipoAgente;

	private String cnpj;

	public Agente(AgenteForm form) {
		this.setTipoAgente(form.getTipoAgente());
		this.setCnpj(form.getCnpj());
		this.setNome(form.getNome());
		this.setLogin(form.getLogin());
		this.setSenha(form.getSenha());
		this.setDataCriacao(LocalDate.now());
		this.setDataModificacao(LocalDate.now());
	}
}
