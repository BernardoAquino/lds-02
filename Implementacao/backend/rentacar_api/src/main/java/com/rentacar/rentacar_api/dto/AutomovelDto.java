package com.rentacar.rentacar_api.dto;

import java.time.LocalDate;

import com.rentacar.rentacar_api.model.Automovel;
import com.rentacar.rentacar_api.model.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomovelDto {
	private String ano;
	private String marca;
	private String modelo;
	private String placa;
	private boolean isEmprestado;
	private boolean contratoCredito;
	private Usuario proprietario;
	private LocalDate dataCriacao;
	private LocalDate dataModificacao;

	public AutomovelDto(Automovel automovel) {
		this.ano = automovel.getAno();
		this.marca = automovel.getMarca();
		this.modelo = automovel.getModelo();
		this.placa  = automovel.getPlaca();		 
		this.isEmprestado = automovel.getIsAlugado() == null ? false : automovel.getIsAlugado();
		this.contratoCredito = automovel.getContratoCredito() == null ? false : automovel.getContratoCredito();
		this.proprietario  = automovel.getProprietario();
		this.dataCriacao  = automovel.getDataCriacao();
		this.dataModificacao  = automovel.getDataModificacao();
	}
	
}

