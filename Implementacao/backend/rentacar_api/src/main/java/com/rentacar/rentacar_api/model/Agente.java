package com.rentacar.rentacar_api.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.rentacar.rentacar_api.dto.PedidoDto;
import com.rentacar.rentacar_api.form.agente.AgenteForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Agente extends Usuario{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;


	@Enumerated
	private TipoAgente tipoAgente;

	private String cnpj;

	public Agente(AgenteForm form) {
		this.setNome(form.getNome());
		this.setLogin(form.getLogin());
		this.setSenha(form.getSenha());
		this.setDataCriacao(LocalDate.now());
		this.setDataModificacao(LocalDate.now());

	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public TipoAgente getTipoAgente() {
		return tipoAgente;
	}

	public void setTipoAgente(TipoAgente tipoAgente) {
		this.tipoAgente = tipoAgente;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
