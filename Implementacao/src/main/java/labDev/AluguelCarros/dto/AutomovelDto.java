package labDev.AluguelCarros.dto;

import java.time.LocalDate;

import labDev.AluguelCarros.model.Automovel;


public class AutomovelDto {


	private String ano;
	private String marca;
	private String modelo;
	private String placa;
	private boolean isEmprestado;
	private String contratoCredito;
	private String proprietario;
	private LocalDate dataCriacao;
	private LocalDate dataModificacao;

	
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


	public boolean isEmprestado() {
		return isEmprestado;
	}


	public void setEmprestado(boolean isEmprestado) {
		this.isEmprestado = isEmprestado;
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


	public AutomovelDto(Automovel automovel) {
		 this.ano = automovel.getAno();
		 this.marca = automovel.getMarca();
		 this.modelo = automovel.getModelo();
		 this.placa  = automovel.getPlaca();
		 this.isEmprestado = automovel.isAlugado();
		 this.contratoCredito = automovel.getContratoCredito();
		 this.proprietario  = automovel.getProprietario();
		 this.dataCriacao  = automovel.getDataCriacao();
		 this.dataModificacao  = automovel.getDataModificacao();
	}
	
}

