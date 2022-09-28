package com.rentacar.rentacar_api.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="pedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private boolean avaliado;
	private boolean parecerDoAgente;

	private LocalDate dataCriacao = LocalDate.now();
	private LocalDate dataModificacao = LocalDate.now();

	@ManyToOne
	private Automovel automovel;

	@ManyToOne
	private Contratante contratante;

	@ManyToOne
	private Usuario analista;

	public Pedido(Automovel automovel, Contratante contratante) {
		this.analista = automovel.getAnalista();
		this.automovel = automovel;
		this.contratante = contratante;
		this.dataCriacao = LocalDate.now();
		this.dataModificacao = LocalDate.now();
	}

}
