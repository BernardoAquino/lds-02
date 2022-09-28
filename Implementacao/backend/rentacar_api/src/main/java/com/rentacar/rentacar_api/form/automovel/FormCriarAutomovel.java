package com.rentacar.rentacar_api.form.automovel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormCriarAutomovel {
	public String ano;
	public String marca;
	public String modelo;
	public String placa;
	public Boolean contratoCredito;
	public Long analistaId;
}
