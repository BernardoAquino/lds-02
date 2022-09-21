package com.rentacar.rentacar_api.dto;

import java.time.LocalDate;

import javax.persistence.ManyToOne;

import com.rentacar.rentacar_api.model.Automovel;
import com.rentacar.rentacar_api.model.Pedido;

public class PedidoDto {


	private boolean parecerDoAgente;
	private LocalDate dataCriacao;
	private LocalDate dataModificacao;
	@ManyToOne
	private Long idAutomovel;

	
	
	public PedidoDto(Pedido p) {
		this.parecerDoAgente = p.isParecerDoAgente();
		this.idAutomovel = p.getIdAutomovel();
		this.setDataCriacao(p.getDataCriacao());
		this.dataModificacao = p.getDataModificacao();
	}

	public boolean isParecerDoAgente() {
		return parecerDoAgente;
	}



	public void setParecerDoAgente(boolean parecerDoAgente) {
		this.parecerDoAgente = parecerDoAgente;
	}



	public LocalDate getDataModificacao() {
		return dataModificacao;
	}



	public void setDataModificacao(LocalDate dataModificacao) {
		this.dataModificacao = dataModificacao;
	}



	public Long getIdAutomovel() {
		return idAutomovel;
	}

	public void setIdAutomovel(Long idAutomovel) {
		this.idAutomovel = idAutomovel;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}



	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}


