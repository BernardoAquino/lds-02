package com.rentacar.rentacar_api.form.automovel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomovelForm {
	public String ano;
	public String marca;
	public String modelo;
	public String placa;
	public Boolean contratoCredito;
	public String proprietario;	

	public AutomovelForm(String ano, String marca, String modelo, String placa, Boolean contratoCredito,
			String proprietario) {
		this.ano = ano;
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.contratoCredito = contratoCredito;
		this.proprietario = proprietario;
	}
}
