package com.rentacar.rentacar_api.form.automovel;


public class AutomovelForm {

	
	public String ano;
	public String marca;
	public String modelo;
	public String placa;
	public String contratoCredito;
	public String proprietario;
	
	

	public AutomovelForm(String ano, String marca, String modelo, String placa, String contratoCredito,
			String proprietario) {
		this.ano = ano;
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.contratoCredito = contratoCredito;
		this.proprietario = proprietario;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getContratoCredito() {
		return contratoCredito;
	}
	public void setContratoCredito(String contratoCredito) {
		this.contratoCredito = contratoCredito;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}


}
