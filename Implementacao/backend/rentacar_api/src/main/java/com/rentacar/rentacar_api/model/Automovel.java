package com.rentacar.rentacar_api.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rentacar.rentacar_api.form.automovel.AutomovelForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="automovel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Automovel {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long matricula;
	private String ano;
	private String marca;
	private String modelo;
	private String placa;
	private boolean isAlugado;
	private String contratoCredito;
	private String proprietario;
	private LocalDate dataCriacao = LocalDate.now();
	private LocalDate dataModificacao = LocalDate.now();

	
	public Automovel(AutomovelForm form) {
		this.setAno(form.ano);
		this.setModelo(form.modelo);
		this.setPlaca(form.placa);
		this.setMarca(form.marca);
		this.setContratoCredito(form.contratoCredito);	
		this.setProprietario(form.proprietario);
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
}
