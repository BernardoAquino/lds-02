package labDev.AluguelCarros.form;

import java.time.LocalDate;
import java.util.Optional;

import labDev.AluguelCarros.model.Automovel;
import labDev.AluguelCarros.repository.AutomovelRepository;

public class AutomovelFormAtualizacao {
	
	public String ano;
	public String marca;
	public String modelo;
	public String placa;
	public String contratoCredito;
	public String proprietario;
	public boolean isEmprestado;
	
	public boolean isEmprestado() {
		return isEmprestado;
	}
	public void setEmprestado(boolean isEmprestado) {
		this.isEmprestado = isEmprestado;
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
	public Automovel atualizar(Long id, AutomovelRepository automovelRepo) {
		Optional<Automovel> automovelOptional= automovelRepo.findById(id);
		if(automovelOptional.isPresent()) {
			Automovel automovel = automovelOptional.get();
			automovel.setAno(this.ano);
			automovel.setMarca(this.marca);
			automovel.setModelo(this.modelo);
			automovel.setPlaca(this.placa);
			automovel.setContratoCredito(this.contratoCredito);
			automovel.setProprietario(this.proprietario);
			automovel.setEmprestado(this.isEmprestado);
			automovel.setDataModificacao(LocalDate.now());
			return automovel;
		}
		return null;
	}
	
	
}
